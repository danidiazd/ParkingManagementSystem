package org.example.contexts.client.entity;

import org.example.contexts.car.entity.Car;


import java.util.UUID;

public class Client {

    private final UUID id = UUID.randomUUID();
    private final String firstName;
    private final String lastName;
    private final Car car;

    public Client(String firstName, String lastName, Car car) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.car = car;
    }

    public UUID getId() {
        return id;
    }


    public String getCar() {
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
