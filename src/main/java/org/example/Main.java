package org.example;

import org.example.contexts.car.application.CarService;
import org.example.contexts.car.infrastructure.MemoryCarRepository;
import org.example.contexts.client.application.ClientService;
import org.example.contexts.client.infrastructure.MemoryClientRepository;
import org.example.contexts.client.userInterface.ClientConsole;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        MemoryCarRepository carRepository = new MemoryCarRepository();

        CarService carService = new CarService(carRepository);

        MemoryClientRepository clientRepository = new MemoryClientRepository();

        ClientService clientService = new ClientService(clientRepository);

        ClientConsole clientConsole = new ClientConsole(clientService);


        while (true) {
            System.out.println("1. Register a new client");
            System.out.println("2. Exit");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    clientConsole.start();
                    break;
                case 2:
                    return;
            }
        }
    }
}