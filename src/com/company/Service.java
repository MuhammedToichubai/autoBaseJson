package com.company;

import com.company.model.Truck;
import com.company.service.ServiceImpl;

import java.util.Scanner;

public class Service {
    public static void autoBase() {
        Scanner scanner = new Scanner(System.in);

        Truck[] trucks = Truck.getTrucks();
        Driver[] drivers = Driver.getDrivers();
        print(trucks);
        print(drivers);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        while (true) {
            System.out.println("Жүк ташуучу унаалардын (Truck) бирин танданыз: ");
            int input = scanner.nextInt();
            //scanner.nextLine();
            Driver.getInfo(trucks[input - 1]);
            ServiceImpl service = new ServiceImpl();
            getInstruction();
            int action = scanner.nextInt();
            switch (action) {
                case 1 -> service.changeDriver(trucks[input - 1], drivers[input - 1]);
                case 2 -> service.startDriving(trucks[input - 1], drivers[input - 1]);
                case 3 -> service.startRepair(trucks[input - 1], drivers[input - 1]);
            }
            print(trucks);
            print(drivers);
        }
    }

    public static void print(Truck[] trucks) {
        System.out.println(">>>>>>>>>>>> * TRUCKS * <<<<<<<<<<<<");
        System.out.println(" # |   Truck     |  Driver  |  State");
        System.out.println("---+-------------+----------+--------");
        for (int j = 0; j < trucks.length; j++) {
            System.out.println(trucks[j]);
        }
    }

    public static void print(Driver[] drivers) {
        System.out.println(">>>>>>>>>> * DRIVERS * <<<<<<<<<<<<<");
        System.out.println(" # |   Driver    |   Bus      ");
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
