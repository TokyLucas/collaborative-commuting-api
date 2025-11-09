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

        if (dto.getPointDepart() != null) existing.setPointDepart(dto.getPointDepart());
        if (dto.getPointArrivee() != null) existing.setPointArrivee(dto.getPointArrivee());
        if (dto.getLatDepart() != null) existing.setLatDepart(dto.getLatDepart());
        if (dto.getLngDepart() != null) existing.setLngDepart(dto.getLngDepart());
        if (dto.getLatArrivee() != null) existing.setLatArrivee(dto.getLatArrivee());
        if (dto.getLngArrivee() != null) existing.setLngArrivee(dto.getLngArrivee());
        if (dto.getHeureDepartEstimee() != null) existing.setHeureDepartEstimee(dto.getHeureDepartEstimee());
        if (dto.getPlacesDisponibles() != null) existing.setPlacesDisponibles(dto.getPlacesDisponibles());
        if (dto.getPlacesDispoJournalier() != null) existing.setPlacesDispoJournalier(dto.getPlacesDispoJournalier());
        if (dto.getDescription() != null) existing.setDescription(dto.getDescription());
        if (dto.getStatut() != null) existing.setStatut(dto.getStatut());
        if (dto.getActif() != null) existing.setActif(dto.getActif());
        if (dto.getVoitureId() != null) existing.setVoitureId(dto.getVoitureId());

        // ✅ Manquants
        if (dto.getJours() != null) existing.setJours(dto.getJours());
        if (dto.getDateDesactivationDebut() != null) existing.setDateDesactivationDebut(dto.getDateDesactivationDebut());
        if (dto.getDateDesactivationFin() != null) existing.setDateDesactivationFin(dto.getDateDesactivationFin());

        return repository.save(existing);
    }


    @Override
    public List<TrajetConducteurDTO> getByIdConducteur(String conducteurId) {
        return repository.findByIdConducteur(conducteurId)
                .stream()
                .map(TrajetConducteurMapper::toDto)
                .toList();
    }

    @Override
    public List<TrajetConducteur> getByStatut(String statut) {
        List<TrajetConducteur> result = repository.findByStatutIgnoreCase(statut);
        return result != null ? result : List.of();
    }
}
