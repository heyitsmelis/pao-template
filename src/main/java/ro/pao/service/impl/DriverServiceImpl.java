package ro.pao.service.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import ro.pao.model.Client;
import ro.pao.model.Driver;
import ro.pao.model.enums.VehicleType;
import ro.pao.service.DriverService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
@NoArgsConstructor
@Getter
public class DriverServiceImpl implements DriverService {
    private static List<Driver> driverList = new ArrayList<>();

    public Scanner scanner = new Scanner(System.in);
    @Override
    public Driver newDriver(){
        Driver currentDriver = null;

        System.out.println("Prenume:");
        String firstName = scanner.nextLine();

        System.out.println("Nume:");
        String lastName = scanner.nextLine();

        System.out.println("Nume de utilizator:");
        String userName = scanner.nextLine();

        UUID accountId = UUID.randomUUID();

        System.out.println("Tipul de vehicul:");
        VehicleType vehicleType = VehicleType.getEnumByFieldString(scanner.nextLine());

        currentDriver = new Driver(firstName, lastName, userName, accountId,vehicleType);
        driverList.add(currentDriver);

        System.out.println("Driver creat cu success!");

        for (Driver person : driverList) {
            System.out.println(person);
        }
        return currentDriver;
    }
}
