package org.ParkingProyect.contexts.car.application;

import org.ParkingProyect.contexts.car.entity.Car;
import org.ParkingProyect.contexts.car.repositories.CarRepository;
import org.ParkingProyect.contexts.car.valueObject.LicensePlate;

import java.util.Optional;

public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void registerCar(Car car) {
        Optional<Car> carOptional = carRepository.findByPlate(car.getLicensePlate());
        if (carOptional.isPresent()) {
            throw new IllegalArgumentException("Car already registered");
        }
        carRepository.save(car);
    }

    public Optional<Car> findCarByPlate(LicensePlate plate) {
        return carRepository.findByPlate(plate);
    }

    public void deleteCar(Car car) {
        carRepository.delete(car);
    }
}
