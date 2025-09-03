package itu.mbds.collaborativecommutingapi.services.car;

import itu.mbds.collaborativecommutingapi.dtos.car.CarDTO;
import itu.mbds.collaborativecommutingapi.entities.Car;
import itu.mbds.collaborativecommutingapi.exceptions.EntityNotFoundException;
import itu.mbds.collaborativecommutingapi.mappers.CarMapper;
import itu.mbds.collaborativecommutingapi.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return carRepository.findById(id)
                .map(carMapper::toCarDTO)
                .orElseThrow(() -> new RuntimeException("Car not found with id: " + id));
    }

    @Override
    public List<CarDTO> getAllByUserId(String userId) {
        return carMapper.toCarDTOs(carRepository.findAllByUserId(userId));
    }

    @Override
    public CarDTO getByUserId(String userId, String carId) {
        Optional<Car> car = carRepository.findByUserIdAndId(userId, carId);
        if (car.isEmpty())
            throw new EntityNotFoundException("Car id: " + carId + " not found");
        return carMapper.toCarDTO(car.get());
    }
}
