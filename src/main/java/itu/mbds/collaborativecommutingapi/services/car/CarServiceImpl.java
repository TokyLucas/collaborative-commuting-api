package itu.mbds.collaborativecommutingapi.services.car;

import itu.mbds.collaborativecommutingapi.dtos.car.CarDTO;
import itu.mbds.collaborativecommutingapi.mappers.CarMapper;
import itu.mbds.collaborativecommutingapi.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements ICarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }
    @Override
    public List<CarDTO> getAll() {
        return List.of();
    }

    @Override
    public CarDTO getById(String id) {
        return null;
    }

    @Override
    public List<CarDTO> getAllByUserId(String userId) {
        return carMapper.toCarDTOs(carRepository.findAllByUser(userId));
    }

    @Override
    public CarDTO getByUserId(String userId, String carId) {
        return carMapper.toCarDTO(carRepository.findByUserAndId(userId, carId).orElse(null));
    }
}
