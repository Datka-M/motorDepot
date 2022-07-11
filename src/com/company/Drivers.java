package com.company;

import com.company.enums.DriverState;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Drivers {
    private int id;
    private String name;
    private DriverState driverState;

    public Drivers(int id, String name, DriverState driverState) {
        this.id = id;
        this.name = name;
        this.driverState = driverState;
    }

    public Drivers() {
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

    public DriverState getDriverState() {
        return driverState;
    }

    public void setDriverState(DriverState driverState) {
        this.driverState = driverState;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void driverJsonMethod(String word){
        try(FileWriter fileWriter = new FileWriter("./driver.json")){
            fileWriter.write(word);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        try (FileReader reader = new FileReader("./driver.json")){
            Scanner scanner = new Scanner(reader);
            while(scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
