package org.example.contexts.client.application;

import org.example.contexts.client.entity.Client;
import org.example.contexts.client.repository.ClientRepository;

import java.util.Optional;
import java.util.UUID;

public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void registerClient(Client client) {
        Optional<Client> clientOptional = clientRepository.findByCarLicensePlate(client.getCar());
        if (clientOptional.isPresent()) {
            throw new IllegalArgumentException("Car already registered");
        }
        clientRepository.save(client);
        System.out.printf("Client saved: " + client);
    }

    public Optional<Client> findClientById(String id) {
        return clientRepository.findById(UUID.fromString(id));
    }

    public void deleteClient(Client client) {
        clientRepository.delete(client);
    }

}
