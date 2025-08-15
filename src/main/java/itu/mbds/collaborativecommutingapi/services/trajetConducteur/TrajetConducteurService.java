package itu.mbds.collaborativecommutingapi.services.trajetConducteur;

import itu.mbds.collaborativecommutingapi.dtos.TrajetConducteurDTO;
import itu.mbds.collaborativecommutingapi.mappers.TrajetConducteurMapper;
import itu.mbds.collaborativecommutingapi.models.TrajetConducteur;
import itu.mbds.collaborativecommutingapi.repositories.TrajetConducteurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TrajetConducteurService implements ITrajetConducteurService {

    private final TrajetConducteurRepository repository;

    public TrajetConducteurService(TrajetConducteurRepository repository) {
        this.repository = repository;
    }

    @Override
    public TrajetConducteur create(TrajetConducteurDTO dto) {
        return repository.save(TrajetConducteurMapper.toEntity(dto));
    }

    @Override
    public List<TrajetConducteur> getAll() {
        return repository.findAll();
    }

    @Override
    public TrajetConducteur getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public TrajetConducteur update(String id, TrajetConducteurDTO dto) {
        TrajetConducteur existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trajet non trouvé"));

        TrajetConducteur updated = TrajetConducteurMapper.toEntity(dto);
        updated.setId(id); // conserver l'ID existant
        updated.setIdConducteur(existing.getIdConducteur()); // si tu ne veux pas le modifier

        return repository.save(updated);
    }

    @Override
    public List<TrajetConducteurDTO> getByIdConducteur(String conducteurId) {
        return repository.findByIdConducteur(conducteurId)
                .stream()
                .map(TrajetConducteurMapper::toDto)
                .toList();
    }
}
