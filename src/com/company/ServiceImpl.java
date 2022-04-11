package com.company;

import java.util.Random;

public class ServiceImpl implements Service {


    @Override
    public void changeDriver(Truck car, Driver driver) {
        if (car.getState().equals("base")) {
            car.setDriver(driver.getName());
            driver.setTruck(car.getName());
        } else if (car.getState().equals("route")) {
            System.err.println("Айдоочу мурунтан эле жолдо!!!");
        } else {
            System.err.println("Сиз айдоочуну алмаштыра албайсыз!!!");
        }
    }

    @Override
    public void startDriving(Truck car, Driver driver) {
        if (car.getState().equals("base")) {
            if (!car.getDriver().equals("")) {
                car.setState("route");
                System.out.println("Айдоочу жолун ийгиликтүү баштады!");
            } else {
                System.err.println("Айдоочу жок!");
            }
        } else if (car.getState().equals("route")) {
            System.err.println("Айдоочу жолдо баратат!");
        } else {
            Random random = new Random();
            int rnd = random.nextInt(2);
            if (rnd == 0) {
                car.setState("route");
                System.out.println("Жүк ташуучу унаа жолдо!");
            } else {
                car.setState("base");
                System.out.println("Жүк ташуучу унаа базада!");
            }
        }
    }

    @Override
    public void startRepair(Truck car, Driver driver) {
        if (car.getState().equals("base")) {
            car.setState("repair");
            System.out.println("Жүк ташуучу унаа азыр ондолуп жатат!");
        } else if (car.getState().equals("route")) {
            car.setState("repair");
        } else {
            System.out.println("Жүк ташуучу унаа буга чейин ондоодо!");

        }
    }
}