package org.example.contexts.client.infrastructure;

import org.example.contexts.client.entity.Client;
import org.example.contexts.client.repository.ClientRepository;

import java.util.*;

public class MemoryClientRepository implements ClientRepository {
    private final Map<UUID, Client> clients = new HashMap<>();

    @Override
    public void save(Client client) {
        clients.put(client.getId(), client);
        System.out.println("Client saved: " + client);
    }

    @Override
    public Optional<Client> findById(UUID id) {
        return Optional.ofNullable(clients.get(id));
    }

    @Override
    public void delete(Client client) {
        clients.remove(client.getId());
        System.out.println("Client removed: " + client);
    }

    @Override
    public List<Client> findAll() {
        return new ArrayList<>(clients.values());

    }

    @Override
    public Optional<Client> findByCarLicensePlate(String licensePlate) {
        return clients.values().stream()
                .filter(client -> client.getCar().getClass().equals(licensePlate))
                .findFirst();
    }
}
