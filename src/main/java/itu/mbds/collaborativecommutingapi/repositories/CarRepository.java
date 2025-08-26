package itu.mbds.collaborativecommutingapi.repositories;

import itu.mbds.collaborativecommutingapi.entities.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends MongoRepository<Car, String> {
    Optional<Car> findByUserIdAndId(String userId, String id);
    List<Car> findAllByUserId(String userId);
}
