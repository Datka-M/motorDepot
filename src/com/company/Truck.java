package com.company;

import com.company.enums.DriverState;
import com.company.enums.TruckState;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Truck {
    private int id ;
    private String name;
    private Drivers drivers;
    private TruckState truckState;

    public Truck(int id, String name, Drivers drivers, TruckState truckState) {
        this.id = id;
        this.name = name;
        this.drivers = drivers;
        this.truckState = truckState;
    }

    public Truck() {
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

    public Drivers getDrivers() {
        return drivers;
    }

    public void setDrivers(Drivers drivers) {
        this.drivers = drivers;
    }

    public TruckState getTruckState() {
        return truckState;
    }

    public void setTruckState(TruckState truckState) {
        this.truckState = truckState;
    }

    @Override
    public String toString() {
        return " "+id +"   |       "+name +"       |      " + drivers+"       |      " +truckState;
    }

    public void changeDriver (List<Truck>trucks,List<Drivers>drivers,int truckId,int driverId) {
        trucks.get(truckId).setDrivers(drivers.get(driverId));
        try {
            if (trucks.get(truckId).getTruckState() == TruckState.REPAIR) {
                throw new MyException("You can't change driver because car in the repair");
            }
            if (trucks.get(truckId).getTruckState() == TruckState.ROUTE) {
                throw new MyException("You can't change driver , if car in the route");
            }
            if (trucks.get(truckId).getDrivers().getDriverState() == DriverState.FREE) {
                trucks.get(truckId).setTruckState(TruckState.ROUTE);
                drivers.get(driverId).setDriverState(DriverState.BUSY);
                System.out.println("Car in the route");
            }
        }catch (MyException e){
            System.out.println(e.getMessage());
        }
    }
    public void startDriving(List<Truck>trucks,List<Drivers>drivers,int truckId,int driverId){
        trucks.get(truckId).setDrivers(drivers.get(driverId));
        try{
            if (trucks.get(truckId).getTruckState()==TruckState.ROUTE){
                throw new MyException("Car in the route");
            }
            if (trucks.get(truckId).getTruckState()==TruckState.BASE){
                trucks.get(truckId).setTruckState(TruckState.ROUTE);
                drivers.get(driverId).setDriverState(DriverState.BUSY);
                System.out.println("Car in t");
            }
            if (trucks.get(truckId).getDrivers().getDriverState()==DriverState.FREE) {
                trucks.get(truckId).setTruckState(TruckState.ROUTE);
                drivers.get(driverId).setDriverState(DriverState.BUSY);
                System.out.println("Car in the route");
            }
            if (trucks.get(truckId).getTruckState()==TruckState.REPAIR){
                trucks.get(truckId).setDrivers(drivers.get(driverId));
                drivers.get(driverId).setDriverState(DriverState.BUSY);
                Random random = new Random();
                int a = random.nextInt(2);
                if (a==0){
                    trucks.get(truckId).setTruckState(TruckState.ROUTE);
                    System.out.println("Car in the route");
                }else{
                    trucks.get(truckId).setTruckState(TruckState.BASE);
                    System.out.println("Car in the base");
                }

            }
        }catch (MyException e){
            System.out.println(e.getMessage());
        }
    }
    public void startRepair(List<Truck>trucks,int truckId){
        try{
            if (trucks.get(truckId).getTruckState()==TruckState.REPAIR){
                throw new MyException("Car in the repair");
            }
            if (trucks.get(truckId).getTruckState()==TruckState.ROUTE){
                trucks.get(truckId).setTruckState(TruckState.REPAIR);
                trucks.get(truckId).getDrivers().setDriverState(DriverState.FREE);
                System.out.println("Car in the repair");
            }
            if (trucks.get(truckId).getTruckState()==TruckState.BASE){
                trucks.get(truckId).setTruckState(TruckState.REPAIR);
                System.out.println("Car in the repair");
            }
        }catch (MyException e){
            System.out.println(e.getMessage());
        }
    }
    public static void busJsonMethod(String word){

        try(FileWriter fileWriter = new FileWriter("./bus.json")){
            fileWriter.write(word);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        try (FileReader reader = new FileReader("./bus.json")){
            Scanner scanner = new Scanner(reader);
            while(scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
