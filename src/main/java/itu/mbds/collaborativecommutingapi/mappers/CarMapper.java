package itu.mbds.collaborativecommutingapi.mappers;

import itu.mbds.collaborativecommutingapi.dtos.car.CarDTO;
import itu.mbds.collaborativecommutingapi.entities.Car;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarMapper {
    public Car toCar(CarDTO carDTO) {
        Car car = new Car();
        car.setId(carDTO.getId());
        car.setBrand(carDTO.getBrand());
        car.setModel(carDTO.getModel());
        car.setColor(carDTO.getColor());
        car.setNbPlaces(carDTO.getNbPlaces());
        car.setUserId(carDTO.getUserId());
        return car;
    }

    public CarDTO toCarDTO(Car car) {
        CarDTO carDTO = new CarDTO();
        carDTO.setId(car.getId());
        carDTO.setBrand(car.getBrand());
        carDTO.setModel(car.getModel());
        carDTO.setColor(car.getColor());
        carDTO.setNbPlaces(car.getNbPlaces());
        carDTO.setUserId(car.getUserId());
        return carDTO;
    }

    public List<CarDTO> toCarDTOs(List<Car> cars) {
        List<CarDTO> carDTOs = new ArrayList<>();
        for(Car car : cars) {
            carDTOs.add(toCarDTO(car));
        }
        return carDTOs;
    }
}
