package org.ParkingProyect;

import org.ParkingProyect.contexts.car.application.CarService;
import org.ParkingProyect.contexts.car.infrastructure.MemoryCarRepository;
import org.ParkingProyect.contexts.client.application.ClientService;
import org.ParkingProyect.contexts.client.infrastructure.MemoryClientRepository;
import org.ParkingProyect.contexts.client.userInterface.ClientConsole;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        MemoryCarRepository carRepository = new MemoryCarRepository();

        CarService carService = new CarService(carRepository);

        MemoryClientRepository clientRepository = new MemoryClientRepository();

        ClientService clientService = new ClientService(clientRepository);

        ClientConsole clientConsole = new ClientConsole(clientService);



        clientConsole.start();    }
}