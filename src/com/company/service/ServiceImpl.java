package com.company.service;

import com.company.Driver;
import com.company.model.Truck;

import java.util.Random;

public class ServiceImpl implements Service {

    @Override
    public void changeDriver(Truck truck, Driver driver) {
        switch (truck.getState()) {
            case "base" -> {
                truck.setDriver(driver.getName());
                driver.setTruck(truck.getName());
            }
            case "route" -> System.out.println("Айдоочу мурунтан эле жолдо!");
            default -> System.out.println("Сиз айдоочуну алмаштыра албайсыз!");
        }
    }

    @Override
    public void startDriving(Truck truck, Driver driver) {
        switch (truck.getState()) {
            case "base":
                if (!truck.getName().equals("")) {
                    truck.setState("route");
                    System.out.println("Айдоочу жолун ийгиликтүү баштады!");
                } else {
                    System.out.println("Айдоочу жок!");
                }
                break;
            case "route":
                System.out.println("Айдоочу жолдо баратат!");
                break;
            default:
                Random random = new Random();
                int rnd = random.nextInt(2);
                if (rnd == 0) {
                    truck.setState("route");
                    System.out.println("Жүк ташуучу унаа жолдо!");
                } else {
                    truck.setState("base");
                    System.out.println("Жүк ташуучу унаа базада!");
                }
                break;
        }
    }

    @Override
    public void startRepair(Truck truck, Driver driver) {
        switch (truck.getState()) {
            case "base" -> {
                truck.setState("repair");
                System.out.println("Жүк ташуучу унаа азыр ондолуп жатат!");
            }
            case "route" -> truck.setState("repair");
            default -> System.out.println("Жүк ташуучу унаа буга чейин ондоодо!");
        }
    }
}