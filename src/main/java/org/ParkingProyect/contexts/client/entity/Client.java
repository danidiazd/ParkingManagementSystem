package org.ParkingProyect.contexts.client.entity;

import org.ParkingProyect.contexts.car.entity.Car;


import java.util.UUID;

public class Client {

    private final UUID id = UUID.randomUUID();
    private final String firstName;
    private final String lastName;
    private final Car car;
    private boolean payed = false;

    public Client(String firstName, String lastName, Car car) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.car = car;
        this.payed = false;
    }

    public UUID getId() {
        return id;
    }


    public Car getCar() {
        return car;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", car=" + car +
                '}';
    }
}
