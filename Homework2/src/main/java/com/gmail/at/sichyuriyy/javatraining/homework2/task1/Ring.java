package com.gmail.at.sichyuriyy.javatraining.homework2.task1;

/**
 * Created by Yuriy on 13.02.2017.
 */
public class Ring implements Shape {

    private double radius;

    private Ring(double radius) {
        this.radius = radius;
    }

    public static Ring getRing(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("radius must be positive number");
        }
        return new Ring(radius);
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getRadius() {
        return radius;
    }
}
