package com.gmail.at.sichyuriyy.javatraining.homework2.task2.impl;

/**
 * Created by Yuriy on 13.02.2017.
 */
public class Motor {

    private double fuelConsuming;

    private Motor(double fuelConsuming) {
        this.fuelConsuming = fuelConsuming;
    }

    public static Motor getMotor(Motor other) {
        return new Motor(other.fuelConsuming);
    }

    public static Motor getMotor(double fuelConsuming) {
        if (fuelConsuming < 0) {
            throw new IllegalArgumentException("fuelConsuming must be positive number");
        }
        return new Motor(fuelConsuming);
    }

    public double getFuelConsuming() {
        return this.fuelConsuming;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Motor))
            return false;

        Motor motor = (Motor) o;

        return Double.compare(motor.fuelConsuming, fuelConsuming) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(fuelConsuming);
        return (int) (temp ^ (temp >>> 32));
    }
}
