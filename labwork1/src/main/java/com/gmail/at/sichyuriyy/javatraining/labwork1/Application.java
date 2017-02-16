package com.gmail.at.sichyuriyy.javatraining.labwork1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Yuriy on 15.02.2017.
 */
public class Application {

    private Apartment apartment;
    private boolean finished;
    Scanner in;

    private Map<Integer, Operation> operations = new HashMap<Integer, Operation>(){{
        put(1, () -> apartment.getAppliances().forEach(System.out::println));
        put(2, () -> apartment.sortByPower());
        put(3, () -> {
            System.out.println("Input powerFrom and powerTo values");
            int powerFrom = in.nextInt();
            int powerTo = in.nextInt();
            apartment.findByPower(powerFrom, powerTo).forEach(System.out::println);
        });
        put(4, () -> System.out.println(apartment.getPowerOfTurnedDevices()));
        put(5, () -> finished = true);
    }};

    public Application() {
        initApartment();
        in = new Scanner(System.in);
    }


    public void start() {
        while (!finished) {
            System.out.println("appliances size: " + apartment.getAppliances().size());
            System.out.println("Menu:");
            System.out.println("1)Show appliances");
            System.out.println("2)Sort appliances by power");
            System.out.println("3)Find by power");
            System.out.println("4)Calculate power usage");
            System.out.println("5)Finish");

            int operationNumber = in.nextInt();

            Operation operation = operations.get(operationNumber);
            if (operation != null) {
                operation.execute();
            }

            System.out.println();
            System.out.println("---------------------------");
        }
    }

    private void initApartment() {
        apartment = new Apartment();
        Appliance coffeeMachine = CoffeeMachine.getCoffeeMachine(40, 4);
        Appliance kettle = Kettle.getKettle(20, 2);
        Appliance washingMachine = WashingMachine.getWashingMachine(200, 15);

        apartment.addAppliance(coffeeMachine);
        apartment.addAppliance(kettle);
        apartment.addAppliance(washingMachine);

        coffeeMachine.turnOn();

    }

    @FunctionalInterface
    private interface Operation {
        void execute();
    }
}
