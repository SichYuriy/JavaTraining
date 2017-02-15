package com.gmail.at.sichyuriyy.javatraining.homework2.task2.impl;

/**
 * Created by Yuriy on 13.02.2017.
 */
public class Wheel {

    private int diameter;

    private Wheel(int diameter) {
        this.diameter = diameter;
    }

    public static Wheel getWheel(Wheel other) {
        return new Wheel(other.diameter);
    }

    public static Wheel getWheel(int diameter) {
        if (diameter < 0) {
            throw new IllegalArgumentException("diameter must be positive number");
        }
        return new Wheel(diameter);
    }

    public int getDiameter() {
        return this.diameter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Wheel))
            return false;

        Wheel wheel = (Wheel) o;

        return diameter == wheel.diameter;
    }

    @Override
    public int hashCode() {
        return diameter;
    }
}
