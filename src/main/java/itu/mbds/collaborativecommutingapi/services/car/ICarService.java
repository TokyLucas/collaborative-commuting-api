package itu.mbds.collaborativecommutingapi.services.car;

import itu.mbds.collaborativecommutingapi.dtos.car.CarDTO;
import itu.mbds.collaborativecommutingapi.dtos.user.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ICarService {
    List<CarDTO> getAll();
    CarDTO getById(String id);
    List<CarDTO> getAllByUserId(String userId);
    CarDTO getByUserId(String userId, String carId);
}
