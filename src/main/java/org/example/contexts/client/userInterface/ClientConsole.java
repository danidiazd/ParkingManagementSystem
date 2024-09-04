package org.example.contexts.client.userInterface;

import org.example.contexts.car.entity.Car;
import org.example.contexts.car.valueObject.LicensePlate;
import org.example.contexts.client.application.ClientService;
import org.example.contexts.client.entity.Client;

import java.util.Optional;
import java.util.Scanner;

public class ClientConsole {

    private final ClientService clientService;

    public ClientConsole(ClientService clientService) {
        this.clientService = clientService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Register client");
            System.out.println("2. Find client by id");
            System.out.println("3. Delete client");
            System.out.println("4. Exit");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    registerClient(scanner);
                    break;
                case 2:
                    findClientById(scanner);
                    break;
                case 3:
                    deleteClient(scanner);
                    break;
                case 4:
                    return;
            }
        }
    }

    private void registerClient(Scanner scanner) {
        System.out.println("Enter client first name:");
        String name = scanner.next();
        System.out.println("Enter client last name:");
        String lastName = scanner.next();
        System.out.println("Enter car license plate:");
        String plate = scanner.next().toUpperCase();
        LicensePlate licensePlate = new LicensePlate(plate);
        Car clientCar = new Car(licensePlate);
        Client client = new Client(name, lastName, clientCar);
        try {
            clientService.registerClient(client);
            System.out.println("Client registered");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void findClientById(Scanner scanner) {
        System.out.println("Enter client id:");
        String id = scanner.next();
        clientService.findClientById(id).ifPresentOrElse(
                client -> System.out.println("Client found: " + client),
                () -> System.out.println("Client not found")
        );
    }

    private void deleteClient(Scanner scanner) {
        System.out.println("Enter client id:");
        String id = scanner.next();
        Optional<Client> client = clientService.findClientById(id);
        if (client.isPresent()) {
            clientService.deleteClient(client.get());
            System.out.println("Client deleted");
        } else {
            System.out.println("Client not found");
        }

    }
}
