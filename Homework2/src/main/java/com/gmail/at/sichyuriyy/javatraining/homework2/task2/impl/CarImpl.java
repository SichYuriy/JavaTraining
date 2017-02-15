package com.gmail.at.sichyuriyy.javatraining.homework2.task2.impl;

import com.gmail.at.sichyuriyy.javatraining.homework2.task2.Car;

/**
 * Created by Yuriy on 13.02.2017.
 */
public class CarImpl implements Car {

    private Wheel frontLeftWheel;
    private Wheel frontRightWheel;
    private Wheel backLeftWheel;
    private Wheel backRightWheel;

    private Motor motor;

    private String brand;

    private double fuelAmount;
    private double maxFuelAmount;

    private CarImpl(String brand, Motor motor,
                    double maxFuelAmount, Wheel wheel) {
        this.brand = brand;
        this.motor = Motor.getMotor(motor);
        this.frontLeftWheel = Wheel.getWheel(wheel);
        this.frontRightWheel = Wheel.getWheel(wheel);
        this.backLeftWheel = Wheel.getWheel(wheel);
        this.backRightWheel = Wheel.getWheel(wheel);
        this.maxFuelAmount = maxFuelAmount;
    }

    public static Car getCar(String brand, Motor motor,
                  double maxFuelAmount, Wheel wheel) {
        if (maxFuelAmount <= 0) {
            throw new IllegalArgumentException("fuelAmount must be positive number");
        }
        if (motor == null || wheel == null || brand == null) {
            throw new IllegalArgumentException("motor or wheel are not defined");
        }
        return new CarImpl(brand, motor, maxFuelAmount, wheel);
    }

    @Override
    public int drive(int meters) {
        if (meters < 0) {
            throw new IllegalArgumentException("meters must be positive number");
        }
        int metersOvercome;
        double km = (double)meters / 1000;
        double fuelNeeded = motor.getFuelConsuming() * km;
        if (fuelNeeded < fuelAmount) {
            metersOvercome = meters;
            fuelAmount -= fuelNeeded;
        } else {
            metersOvercome = (int)(fuelAmount * (1d / motor.getFuelConsuming()) * 1000);
            fuelAmount = 0;
        }
        return metersOvercome;
    }

    @Override
    public void refill(double addFuelAmount) {
        if (addFuelAmount < 0) {
            throw new IllegalArgumentException("addFuelAmount must be positive number");
        }
        if (fuelAmount + addFuelAmount > maxFuelAmount) {
            fuelAmount = maxFuelAmount;
        } else {
            fuelAmount += addFuelAmount;
        }
    }

    @Override
    public double getFuelAmount() {
        return this.fuelAmount;
    }

    @Override
    public double getMaxFuelAmount() {
        return this.maxFuelAmount;
    }

    @Override
    public void changeFrontLeftWheel(Wheel wheel) {
        checkWheel(wheel);
        this.frontLeftWheel = Wheel.getWheel(wheel);
    }

    @Override
    public void changeFrontRightWheel(Wheel wheel) {
        checkWheel(wheel);
        this.frontRightWheel = Wheel.getWheel(wheel);
    }

    @Override
    public void changeBackLeftWheel(Wheel wheel) {
        checkWheel(wheel);
        this.backLeftWheel = Wheel.getWheel(wheel);
    }

    @Override
    public void changeBackRightWheel(Wheel wheel) {
        checkWheel(wheel);
        this.backRightWheel = Wheel.getWheel(wheel);
    }

    @Override
    public String getBrand() {
        return this.brand;
    }

    private void checkWheel(Wheel wheel) {
        if (wheel == null) {
            throw new IllegalArgumentException("wheel must not be null");
        }
    }

    public Wheel getFrontLeftWheel() {
        return Wheel.getWheel(frontLeftWheel);
    }

    public Wheel getFrontRightWheel() {
        return Wheel.getWheel(frontRightWheel);
    }

    public Wheel getBackLeftWheel() {
        return Wheel.getWheel(backLeftWheel);
    }

    public Wheel getBackRightWheel() {
        return Wheel.getWheel(backRightWheel);
    }

    public Motor getMotor() {
        return motor;
    }
}
