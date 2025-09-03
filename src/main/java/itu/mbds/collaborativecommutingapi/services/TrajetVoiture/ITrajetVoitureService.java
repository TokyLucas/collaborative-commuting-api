package itu.mbds.collaborativecommutingapi.services.TrajetVoiture;

import itu.mbds.collaborativecommutingapi.models.TrajetConducteur;
import itu.mbds.collaborativecommutingapi.models.TrajetVoitureView;

import java.util.List;

public interface ITrajetVoitureService {
    List<TrajetVoitureView> getAll();
}
