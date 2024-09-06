package org.ParkingProyect.contexts.client.userInterface;

import org.ParkingProyect.contexts.car.entity.Car;
import org.ParkingProyect.contexts.car.valueObject.LicensePlate;
import org.ParkingProyect.contexts.client.application.ClientService;
import org.ParkingProyect.contexts.client.entity.Client;

import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

public class ClientConsole {

    private final ClientService clientService;

    public ClientConsole(ClientService clientService) {
        this.clientService = clientService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Register client");
            System.out.println("2. Find client by id or license plate");
            System.out.println("3. Find all clients");
            System.out.println("4. Delete client");
            System.out.println("5. Exit");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            switch (option) {
                case 1:
                    registerClient(scanner);
                    break;
                case 2:
                    findClientByIdOrLicensePlate(scanner);
                    break;
                case 3:
                    findAllClients();
                    break;
                case 4:
                    deleteClient(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option");
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
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void findClientByIdOrLicensePlate(Scanner scanner) {
        System.out.println("Enter client id or license plate:");
        String idOrLicensePlate = scanner.next();
        Optional<Client> client;
        try {
            client = clientService.findClientById(idOrLicensePlate);
        } catch (IllegalArgumentException e) {
            client = clientService.findClientByCarLicensePlate(idOrLicensePlate);
        }
        if (client.isPresent()) {
            System.out.println(client.get());
        } else {
            System.out.println("Client not found");
        }
    }

    private void findAllClients() {
        clientService.findAllClients().forEach(System.out::println);
    }

    private void deleteClient(Scanner scanner) {
        System.out.println("Enter client id or license plate:");
        String idOrLicensePlate = scanner.next();
        Optional<Client> client;
        try {
            client = clientService.findClientById(idOrLicensePlate);
        } catch (IllegalArgumentException e) {
            client = clientService.findClientByCarLicensePlate(idOrLicensePlate);
        }
        if (client.isPresent()) {
            clientService.deleteClient(client.get());
            System.out.println("Client deleted");
        } else {
            System.out.println("Client not found");
        }
    }
}
