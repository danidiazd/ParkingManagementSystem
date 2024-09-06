package org.ParkingProyect.contexts.client.application;

import org.ParkingProyect.contexts.car.entity.Car;
import org.ParkingProyect.contexts.client.entity.Client;
import org.ParkingProyect.contexts.client.repository.ClientRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void registerClient(Client client) {
        Optional<Client> clientOptional = clientRepository.findByCarLicensePlate(client.getCar().getLicensePlate().getPlate());
        if (clientOptional.isPresent()) {
            throw new IllegalArgumentException("Car already registered");
        }
        clientRepository.save(client);
        System.out.println("Client saved: " + client + "\n");
    }

    public Optional<Client> findClientById(String id) {
        return clientRepository.findById(UUID.fromString(id));
    }

    public void deleteClient(Client client) {
        clientRepository.delete(client);
    }

    public List findAllClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> findClientByCarLicensePlate(String licensePlate) {
        return clientRepository.findByCarLicensePlate(licensePlate);
    }
}
