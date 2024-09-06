package org.ParkingProyect.contexts.car.UserInterface;

import org.ParkingProyect.contexts.car.application.CarService;
import org.ParkingProyect.contexts.car.entity.Car;
import org.ParkingProyect.contexts.car.valueObject.LicensePlate;

import java.util.Scanner;

public class CarConsole {

    private final CarService carService;

    public CarConsole(CarService carService) {
        this.carService = carService;
    }


    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Register car");
            System.out.println("2. Find car by plate");
            System.out.println("3. Delete car");
            System.out.println("4. Exit");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    registerCar(scanner);
                    break;
                case 2:
                    findCarByPlate(scanner);
                    break;
                case 3:
                    deleteCar(scanner);
                    break;
                case 4:
                    return;
            }
        }
    }

    private void registerCar(Scanner scanner) {
        System.out.println("Enter license plate:");
        String plate = scanner.next().toUpperCase();

        try {
            LicensePlate licensePlate = new LicensePlate(plate);
            if (licensePlate.isValid()) {
                Car car = new Car(licensePlate);
                carService.registerCar(car);
                System.out.println("Car registered");
            } else {
                System.out.println("Invalid plate");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void findCarByPlate(Scanner scanner) {
        System.out.println("Enter license plate:");
        String plate = scanner.next();
        LicensePlate licensePlate = new LicensePlate(plate);
        carService.findCarByPlate(licensePlate).ifPresentOrElse(
                car -> System.out.println("Car found: " + car),
                () -> System.out.println("Car not found")
        );
    }

    private void deleteCar(Scanner scanner) {
        System.out.println("Enter license plate:");
        String plate = scanner.next();
        LicensePlate licensePlate = new LicensePlate(plate);
        carService.findCarByPlate(licensePlate).ifPresentOrElse(
                car -> {
                    carService.deleteCar(car);
                    System.out.println("Car deleted");
                },
                () -> System.out.println("Car not found")
        );
    }
}
