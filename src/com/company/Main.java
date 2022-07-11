package com.company;

import com.company.enums.TruckState;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final GsonBuilder GSON_BUILDER = new GsonBuilder();
    public static final Gson GSON = GSON_BUILDER.setPrettyPrinting().create();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Truck truck1 = new Truck(1,"Speed",null, TruckState.BASE);
        Truck truck2 = new Truck(2,"Volvo",null, TruckState.BASE);
        Truck truck3 = new Truck(3,"Prius",null, TruckState.BASE);

        List<Truck>truckList = new ArrayList<>(Arrays.asList(truck1,truck2,truck3));

        Drivers drivers1 = new Drivers(1,"Dastan",null);
        Drivers drivers2 = new Drivers(2,"Jaulan",null);
        Drivers drivers3 = new Drivers(3,"Maksat",null);

        List<Drivers>drivers = new ArrayList<>(Arrays.asList(drivers1,drivers2,drivers3));



//        String json = GSON.toJson(truckList);
//        Truck.busJsonMethod(json);
//        System.out.println("------------------------------------------");
//        String jsonDriver = GSON.toJson(drivers);
//        Drivers.driverJsonMethod(jsonDriver);


        System.out.println("\n\n+++++++++++++++++++++DRIVER+++++++++++++++++");
        System.out.println(" #  |     Driver      |   Truck       | ");
        System.out.println(" "+drivers1.getId()+ "  |    "+drivers1.getName()+"       |               | ");
        System.out.println(" "+drivers2.getId()+ "  |    "+drivers2.getName()+"       |               |");
        System.out.println(" "+drivers3.getId()+ "  |    "+drivers3.getName()+"       |               |");

        System.out.println();
        System.out.println("\n+++++++++++++++++++++++TRUCK++++++++++++++++++++++++++");
        System.out.println(" #   |      Truck        |   Driver        |    State ");
        System.out.println("-----+-------------------+-----------------+---------------");
        for (Truck t :truckList ) {
            System.out.println(t);
        }

        Truck truck = new Truck();


        while (true) {
            System.out.println("Choose one of the car");
            int num = scanner.nextInt();
            switch (num) {
                case 1:
                    System.out.println("Press 1 to change driver");
                    System.out.println("Press 2 to start driving");
                    System.out.println("Press 3 to start repair");
                    int num2 = scanner.nextInt();
                    if (num2 == 1) {
                        System.out.println("change driver");
                        truck.changeDriver(truckList, drivers, 1, 1);
                        truckTable(truckList);
                        System.out.println("You change driver");
                    } else if (num2 == 2) {
                        System.out.println("Start driving");
                        truck.startDriving(truckList, drivers, 1, 2);
                        truckTable(truckList);
                    } else if (num2 == 3) {
                        System.out.println("Start repair");
                        truck.startRepair(truckList, 1);
                        truckTable(truckList);
                    } else {
                        System.out.println("choose 1 2 or 3");
                    }
                    break;
                case 2:
                    System.out.println("Press 1 to change driver");
                    System.out.println("Press 2 to start driving");
                    System.out.println("Press 3 to start repair");
                    int num3 = scanner.nextInt();
                    if (num3 == 1) {
                        System.out.println("Change driver");
                        truck.changeDriver(truckList, drivers, 2, 2);
                        truckTable(truckList);
                        System.out.println("You changed driver");
                    } else if (num3 == 2) {
                        System.out.println("Start driving");
                        truck.startDriving(truckList, drivers, 2, 2);
                        truckTable(truckList);
                        System.out.println("Car in the route");
                    } else {
                        System.out.println("Choose 1 2 or 3");
                    }
                    break;
                case 3:
                    System.out.println("Press 1 to change driver");
                    System.out.println("Press 2 to start driving");
                    System.out.println("Press 3 to start repair");
                    int num4 = scanner.nextInt();
                    if (num4 == 1) {
                        System.out.println("Change driver");
                        truck.changeDriver(truckList, drivers, 3, 1);
                        truckTable(truckList);
                        System.out.println("You changed driver");
                    } else if (num4 == 2) {
                        System.out.println("Start route or base");
                        truck.startDriving(truckList, drivers, 3, 2);
                        truckTable(truckList);
                    }else if (num4==3){
                        truck.startRepair(truckList,3);
                    } else {
                        System.out.println("Choose 1 2 or 3");
                    }
                    break;
                default:
                    System.out.println("You can choose 1 2 or 3");
            }
        }
    }
    static void truckTable(List<Truck>truckList){

        System.out.println("+++++++++++++++++++++++TRUCK++++++++++++++++++++++++++");
        System.out.println(" #   |      Truck        |   Driver        |    State ");
        System.out.println("-----+-------------------+-----------------+---------------");
        for (Truck t :truckList ) {
            System.out.println(t);
        }
    }
}
