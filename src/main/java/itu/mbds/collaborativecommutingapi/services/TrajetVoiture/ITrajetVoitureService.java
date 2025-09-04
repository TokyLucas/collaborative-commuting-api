package itu.mbds.collaborativecommutingapi.services.TrajetVoiture;

import itu.mbds.collaborativecommutingapi.models.TrajetConducteur;
import itu.mbds.collaborativecommutingapi.models.TrajetVoitureView;

import java.util.List;
import java.util.Optional;

public interface ITrajetVoitureService {
    List<TrajetVoitureView> getAll();
    public Optional<TrajetVoitureView> get(String id);
}
