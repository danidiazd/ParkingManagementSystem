package org.ParkingProyect.contexts.car.repositories;

import org.ParkingProyect.contexts.car.entity.Car;
import org.ParkingProyect.contexts.car.valueObject.LicensePlate;

import java.util.Optional;

public interface CarRepository {

    void save(Car car);

    Optional<Car> findByPlate(LicensePlate licensePlate);

    void delete(Car car);
}

