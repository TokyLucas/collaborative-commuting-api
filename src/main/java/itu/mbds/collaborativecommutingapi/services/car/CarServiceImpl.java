package itu.mbds.collaborativecommutingapi.services.car;

import itu.mbds.collaborativecommutingapi.dtos.car.CarDTO;
import itu.mbds.collaborativecommutingapi.entities.Car;
import itu.mbds.collaborativecommutingapi.entities.User;
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
        return null;
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

    @Override
    public CarDTO save(CarDTO carDTO) {
        return carMapper.toCarDTO(carRepository.save(carMapper.toCar(carDTO)));
    }

    @Override
    public CarDTO update(String carId, CarDTO carDTO) {
        Optional<Car> car = carRepository.findById(carId);
        if (car.isEmpty())
            throw new EntityNotFoundException("Car id: " + carId + " not found");
        Car carExistant = car.get();
        carExistant.setBrand(carDTO.getBrand());
        carExistant.setModel(carDTO.getModel());
        carExistant.setColor(carDTO.getColor());
        carExistant.setNbPlaces(carDTO.getNbPlaces());

        return carMapper.toCarDTO(carRepository.save(carExistant));
    }

    @Override
    public void delete(String cardId) {
        carRepository.deleteById(cardId);
    }
}
