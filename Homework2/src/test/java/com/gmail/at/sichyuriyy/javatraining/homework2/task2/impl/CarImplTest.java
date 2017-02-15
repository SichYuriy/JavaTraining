package com.gmail.at.sichyuriyy.javatraining.homework2.task2.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 13.02.2017.
 */
public class CarImplTest {

    private static final double DELTA = 10e-7;

    private CarImpl car;



    @Before
    public void setUp() throws Exception {
        Motor motor = Motor.getMotor(0.4);
        Wheel wheel = Wheel.getWheel(100);
        car = (CarImpl) CarImpl.getCar("brand", motor, 6, wheel);
    }

    @After
    public void tearDown() throws Exception {
        car = null;
    }

    @Test
    public void getCar() {
        Motor expectedMotor = Motor.getMotor(0.4);
        Wheel expectedWheel = Wheel.getWheel(100);
        String expectedBrand = "brand";
        double expectedMaxFuelAmount = 6;
        double expectedFuelAmount = 0;
        assertEquals(expectedBrand, car.getBrand());
        assertEquals(expectedWheel, car.getFrontLeftWheel());
        assertEquals(expectedWheel, car.getFrontRightWheel());
        assertEquals(expectedWheel, car.getBackLeftWheel());
        assertEquals(expectedWheel, car.getBackRightWheel());
        assertEquals(expectedMotor, car.getMotor());
        assertEquals(expectedFuelAmount, car.getFuelAmount(), DELTA);
        assertEquals(expectedMaxFuelAmount, car.getMaxFuelAmount(), DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getCarNull() throws Exception {
        CarImpl.getCar("brand", null, 4, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getCarNegative() throws Exception {
        CarImpl.getCar("brand",
                Motor.getMotor(2),
                -4,
                Wheel.getWheel(12));
    }


    @Test
    public void drive() throws Exception {
        car.refill(6);
        int expectedDriveLength = 200;
        double expectedFuelAmount = 5.92;
        int actualDriveLength = car.drive(200);
        double actualFuelAmount = car.getFuelAmount();
        assertEquals(expectedDriveLength, actualDriveLength);
        assertEquals(expectedFuelAmount, actualFuelAmount, DELTA);
    }

    @Test
    public void driveMoreThenFuel() throws Exception {
        car.refill(1);
        int expectedDriveLength = 2500;
        double expectedFuelAmount = 0;
        int actual = car.drive(3000);
        double actualFuelAmount = car.getFuelAmount();
        assertEquals(expectedDriveLength, actual);
        assertEquals(expectedFuelAmount, actualFuelAmount, DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void driveMoreThenFuelNegative() throws Exception {
        car.drive(-100);
    }

    @Test
    public void refill() throws Exception {
        car.refill(4);
        double expectedFuelAmount = 4;
        double actualFuelAmount = car.getFuelAmount();
        assertEquals(expectedFuelAmount, actualFuelAmount, DELTA);
    }

    @Test
    public void refillMoreThenMax() throws Exception {
        car.refill(12);
        double expectedFuelAmount = 6;
        double actualFuelAmount = car.getFuelAmount();
        assertEquals(expectedFuelAmount, actualFuelAmount, DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void refillNegative() throws Exception {
        car.refill(-6);
    }

    @Test
    public void changeFrontLeftWheel() throws Exception {
        Wheel wheel = Wheel.getWheel(99);
        car.changeFrontLeftWheel(wheel);
        assertEquals(wheel, car.getFrontLeftWheel());
    }

    @Test
    public void changeFrontRightWheel() throws Exception {
        Wheel wheel = Wheel.getWheel(99);
        car.changeFrontRightWheel(wheel);
        assertEquals(wheel, car.getFrontRightWheel());
    }

    @Test
    public void changeBackLeftWheel() throws Exception {
        Wheel wheel = Wheel.getWheel(99);
        car.changeBackLeftWheel(wheel);
        assertEquals(wheel, car.getBackLeftWheel());
    }

    @Test
    public void changeBackRightWheel() throws Exception {
        Wheel wheel = Wheel.getWheel(99);
        car.changeBackRightWheel(wheel);
        assertEquals(wheel, car.getBackRightWheel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void changeFrontLeftWheelNull() throws Exception {
        car.changeFrontLeftWheel(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void changeFrontRightWheelNull() throws Exception {
        car.changeFrontRightWheel(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void changeBackLeftWheelNull() throws Exception {
        car.changeBackLeftWheel(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void changeBackRightWheelNull() throws Exception {
        car.changeBackRightWheel(null);
    }

    @Test
    public void getBrand() throws Exception {
        String expectedBrand = "brand";
        String actualBrand = car.getBrand();
        assertEquals(expectedBrand, actualBrand);
    }

}