package org.example.contexts.car.repositories;

import org.example.contexts.car.entity.Car;
import org.example.contexts.car.valueObject.LicensePlate;

import java.util.Optional;

public interface CarRepository {

    void save(Car car);

    Optional<Car> findByPlate(LicensePlate licensePlate);

    void delete(Car car);
}

