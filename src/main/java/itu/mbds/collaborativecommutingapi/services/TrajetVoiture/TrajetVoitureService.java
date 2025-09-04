package itu.mbds.collaborativecommutingapi.services.TrajetVoiture;

import itu.mbds.collaborativecommutingapi.models.TrajetVoitureView;
import itu.mbds.collaborativecommutingapi.repositories.TrajetConducteurRepository;
import itu.mbds.collaborativecommutingapi.repositories.TrajetVoitureViewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrajetVoitureService implements ITrajetVoitureService {

    private final TrajetVoitureViewRepository repository;

    public TrajetVoitureService(TrajetVoitureViewRepository repository) {
        this.repository = repository;
    }
    @Override
    public List<TrajetVoitureView> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<TrajetVoitureView> get(String id) {
        return repository.findById(id);
    }
}
