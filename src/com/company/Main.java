package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

//        Truck[] trucks1 = Truck.getTruck();
//        Driver[] drivers1 = Driver.getDrivers();
//        System.out.println("======================================");
//        print(trucks1);
//        print(drivers1);

        Truck[] trucks = {
                new Truck(1, "Rambo", "", "base"),
                new Truck(2, "Lady", "", "base"),
                new Truck(3, "El Grande", "", "base")
        };
        Driver[] drivers = {
                new Driver(1,"Өмүр"),
                new Driver( 2,"Илим"),
                new Driver(3,"Билим")
        };
        print(trucks);
        print(drivers);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        while (true) {
            System.out.println("Жүк ташуучу унаалардын (Truck) бирин танданыз: ");
            int input = scanner.nextInt();
            scanner.nextLine();
            Driver.getInfo(trucks[input - 1]);
            ServiceImpl service = new ServiceImpl();
            getInstruction();
            String action = scanner.nextLine();
            if (action.equals("1")) {
                service.changeDriver(trucks[input - 1], drivers[input - 1]);
            } else if (action.equals("2")) {
                service.startDriving(trucks[input - 1], drivers[input - 1]);
            } else if (action.equals("3")) {
                service.startRepair(trucks[input - 1], drivers[input - 1]);
            }
            print(trucks);
            print(drivers);
        }
    }

    public static void print(Truck[] cars) {
        System.out.println(">>>>>>>>>>>> * TRUCKS * <<<<<<<<<<<<");
        System.out.println(" # |   Truck     |  Driver  |  State");
        System.out.println("---+-------------+----------+---------");
        for (int j = 0; j < cars.length; j++) {
            System.out.println(cars[j]);
        }
    }

    public static void print(Driver[] drivers) {
        System.out.println(">>>>>>>>>> * DRIVERS * <<<<<<<<<<<<<");
        System.out.println(" # |   Driver    |   Truck      ");
        System.out.println("---+-------------+-------------------");
        for (int j = 0; j < drivers.length; j++) {
            System.out.println(drivers[j]);
        }
    }

    public static void getInstruction() {
        System.out.println("Driver_ди өзгөртүү үчүн 1ди басыныз.");
        System.out.println("Truck_унаасын айдоо үчүн 2ни басыныз.");
        System.out.println("Truck_унаасын ондоо (repair) үчүн 3ту басыныз");
    }
}