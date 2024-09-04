package org.example.contexts.car.entity;

import org.example.contexts.car.valueObject.LicensePlate;

import java.util.UUID;

public class Car {

    private final UUID id = UUID.randomUUID();
    private final LicensePlate licensePlate;


    public Car(LicensePlate licensePlate) {
        this.licensePlate = licensePlate;
    }

    public LicensePlate getLicensePlate() {
        return licensePlate;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", licensePlate=" + licensePlate +
                '}';
    }
}
