package org.ParkingProyect.contexts.client.repository;

import org.ParkingProyect.contexts.car.entity.Car;
import org.ParkingProyect.contexts.client.entity.Client;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientRepository {

    void save(Client client);

    Optional<Client> findById(UUID id);

    void delete(Client client);

    List<Client> findAll();

    Optional<Client> findByCarLicensePlate(String licensePlate);
}
