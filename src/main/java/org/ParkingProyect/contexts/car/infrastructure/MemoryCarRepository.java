package org.ParkingProyect.contexts.car.infrastructure;

import org.ParkingProyect.contexts.car.entity.Car;
import org.ParkingProyect.contexts.car.repositories.CarRepository;
import org.ParkingProyect.contexts.car.valueObject.LicensePlate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MemoryCarRepository implements CarRepository {

    private final Map<LicensePlate, Car> cars = new HashMap<>();

    @Override
    public void save(Car car) {
        cars.put(car.getLicensePlate(), car);
        System.out.println("Car saved: " + car);
    }

    @Override
    public Optional<Car> findByPlate(LicensePlate licensePlate) {
        return Optional.ofNullable(cars.get(licensePlate));
    }

    @Override
    public void delete(Car car) {
        cars.remove(car.getLicensePlate());
        System.out.println("Car removed: " + car);
    }
}
