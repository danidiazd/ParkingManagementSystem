package org.ParkingProyect.contexts.client.infrastructure;

import org.ParkingProyect.contexts.car.entity.Car;
import org.ParkingProyect.contexts.client.entity.Client;
import org.ParkingProyect.contexts.client.repository.ClientRepository;

import java.util.*;

public class MemoryClientRepository implements ClientRepository {
    private final Map<UUID, Client> clients = new HashMap<>();

    @Override
    public void save(Client client) {
        clients.put(client.getId(), client);
    }

    @Override
    public Optional<Client> findById(UUID id) {
        return Optional.ofNullable(clients.get(id));
    }

    @Override
    public void delete(Client client) {
        clients.remove(client.getId());
    }

    @Override
    public List<Client> findAll() {
        return new ArrayList<>(clients.values());
    }

    @Override
    public Optional<Client> findByCarLicensePlate(String licensePlate) {
        return clients.values().stream()
                .filter(client -> client.getCar().getLicensePlate().getPlate().equalsIgnoreCase(licensePlate))
                .findFirst();
    }
}