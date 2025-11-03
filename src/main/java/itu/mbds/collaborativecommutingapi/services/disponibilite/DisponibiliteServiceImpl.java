package itu.mbds.collaborativecommutingapi.services.disponibilite;

import itu.mbds.collaborativecommutingapi.dtos.disponibilite.DisponibiliteDTO;
import itu.mbds.collaborativecommutingapi.dtos.disponibilite.DisponibiliteRequestDTO;
import itu.mbds.collaborativecommutingapi.entities.Disponibilite;
import itu.mbds.collaborativecommutingapi.exceptions.EntityNotFoundException;
import itu.mbds.collaborativecommutingapi.mappers.DisponibiliteMapper;
import itu.mbds.collaborativecommutingapi.repositories.DisponibiliteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DisponibiliteServiceImpl implements IDisponibiliteService {
    private final DisponibiliteRepository repo;
    private final DisponibiliteMapper mapper;
    private final SimpMessagingTemplate bus;

    @Autowired
    public DisponibiliteServiceImpl(DisponibiliteRepository repo,
                                    DisponibiliteMapper mapper,
                                    SimpMessagingTemplate bus) {
        this.repo = repo;
        this.mapper = mapper;
        this.bus = bus;
    }

    @Override
    public DisponibiliteDTO create(DisponibiliteRequestDTO dto) {
        Disponibilite e = repo.save(mapper.toEntity(dto));
        DisponibiliteDTO out = mapper.toDTO(e);
        bus.convertAndSend("/topic/disponibilites", out);
        return out;
    }

    @Override
    public DisponibiliteDTO updatePosition(String conducteurId, DisponibiliteRequestDTO dto) {
        Disponibilite e = repo.findByConducteurId(conducteurId)
                .orElseThrow(() -> new EntityNotFoundException("Disponibilite not found"));
        e.setPosition(dto.getPosition());
        e = repo.save(e);
        DisponibiliteDTO out = mapper.toDTO(e);
        bus.convertAndSend("/topic/disponibilites", out);
        return out;
    }

    @Override
    public DisponibiliteDTO updateStatut(String conducteurId, itu.mbds.collaborativecommutingapi.enums.DisponibiliteStatut statut) {
        Disponibilite e = repo.findByConducteurId(conducteurId)
                .orElseThrow(() -> new EntityNotFoundException("Disponibilite not found"));
        e.setStatut(statut);
        e = repo.save(e);
        DisponibiliteDTO out = mapper.toDTO(e);
        bus.convertAndSend("/topic/disponibilites", out);
        return out;
    }

    @Override
    public List<DisponibiliteDTO> findNearby(Point location, Distance radius) {
        return repo.findNearbyConducteursDisponibles(location, radius.getNormalizedValue())
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

}
