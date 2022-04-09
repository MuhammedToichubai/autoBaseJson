package com.company;

import com.company.model.Truck;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Driver {
    public static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson GSON = BUILDER.setPrettyPrinting().create();
    public static final Path WRITE_PATH = Paths.get("./drivers.json");
    private int id;
    private String name;
    private String truck;

    public String getTruck() {
        return truck;
    }

    public void setTruck(String truck) {
        this.truck = truck;
    }

    public Driver(int id, String driver) {
        this.id = id;
        this.name = driver;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Driver[] getDrivers() {
        Driver[] drivers = {
                new Driver(1, "Өмүр "),
                new Driver(2, "Илим "),
                new Driver(3, "Билим")
        };

        Gson gson=new Gson();
        String json=GSON.toJson(drivers);
        writeDriverFile(json);
        System.out.println(readDriverFile());

        Driver[] drivers1 = GSON.fromJson(readDriverFile(), Driver[].class);
        for (Driver driver : drivers1) {
            System.out.println(driver.toString());
        }
        return drivers;
    }

    public static void writeDriverFile(String object) {
        Path write = Paths.get(String.valueOf(WRITE_PATH));
        try {
            Files.writeString(write, object, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readDriverFile() {
        String json = "";
        try {
            FileReader fileReader = new FileReader(String.valueOf(WRITE_PATH));
            int a;
            while ((a = fileReader.read()) != -1) {
                json += (char) a;
            }
            return json;
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return json;
    }

    public static void getInfo(Truck truck) {
        System.out.println("N: " + truck.getId());
        System.out.println("Truck name: " + truck.getName());
        System.out.println("Driver: " + truck.getDriver());
        System.out.println("State: " + truck.getState());
    }

    @Override
    public String toString() {
        return
                " " + id +
                        " | " + name +
                        "       | " + truck;
    }
}
