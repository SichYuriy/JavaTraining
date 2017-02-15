package com.gmail.at.sichyuriyy.javatraining.labwork1;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 15.02.2017.
 */
public class ApartmentTest {

    private Apartment apartment;
    Appliance coffeeMachine;
    Appliance kettle;
    Appliance washingMachine;

    @Before
    public void setUp() throws Exception {
        apartment = new Apartment();
        coffeeMachine = CoffeeMachine.getCoffeeMachine(40, 4);
        kettle = Kettle.getKettle(20, 2);
        washingMachine = WashingMachine.getWashingMachine(200, 15);

        apartment.addAppliance(coffeeMachine);
        apartment.addAppliance(kettle);
        apartment.addAppliance(washingMachine);

        coffeeMachine.turnOn();

    }

    @Test
    public void sortByPower() throws Exception {
        String expected = "["
                + kettle + ", "
                + coffeeMachine + ", "
                + washingMachine + "]";
        String actual = apartment.sortByPower().toString();
        assertEquals(expected, actual);
    }

    @Test
    public void findByPower() throws Exception {
        int powerFrom = 10;
        int powerTo = 50;
        String expected = "["
                + coffeeMachine + ", "
                + kettle + "]";
        String actual = apartment.findByPower(powerFrom, powerTo).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void getPowerOfTurnedDevices() throws Exception {
        int expected = 40;
        int actual = apartment.getPowerOfTurnedDevices();
        assertEquals(expected, actual);
    }

}