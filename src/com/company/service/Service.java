package com.company.service;

import com.company.Driver;
import com.company.model.Truck;

public interface Service {
    void changeDriver(Truck truck, Driver driver);
    void startDriving(Truck truck,Driver driver);
    void startRepair(Truck truck,Driver driver);
}
