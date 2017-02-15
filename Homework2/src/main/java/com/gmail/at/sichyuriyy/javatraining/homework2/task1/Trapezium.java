package com.gmail.at.sichyuriyy.javatraining.homework2.task1;

/**
 * Created by Yuriy on 13.02.2017.
 */
public class Trapezium implements Shape {

    private double longerBaseAge;
    private double shorterBaseAge;
    private double longerSide;
    private double shorterSide;

    private Trapezium(double longerBaseAge, double shorterBaseAge, double longerSide, double shorterSide) {
        this.longerBaseAge = longerBaseAge;
        this.shorterBaseAge = shorterBaseAge;
        this.longerSide = longerSide;
        this.shorterSide = shorterSide;
    }

    public static Trapezium getTrapezium(double longerBaseAge, double shorterBaseAge,
                                         double longerSide, double shorterSide) {

        if (longerBaseAge <= 0 || shorterBaseAge <= 0
                || longerSide <= 0 || shorterSide <= 0) {
            throw new IllegalArgumentException("sides must be positive numbers");
        }

        double epsilon = 10e-7;
        if (Math.abs(longerBaseAge - shorterBaseAge) < epsilon) {
            throw new IllegalArgumentException("baseAges must have different values");
        }

        if (longerBaseAge < shorterBaseAge
                || longerSide < shorterSide) {
            throw new IllegalArgumentException();
        }
        return new Trapezium(longerBaseAge, shorterBaseAge, longerSide, shorterSide);
    }

    @Override
    public double getArea() {
        double a = shorterBaseAge;
        double b = longerBaseAge;
        double c = longerSide;
        double d = shorterSide;

        return (a + b)
                * Math.sqrt(c * c
                    - Math.pow(((b - a) * (b - a) + c * c - d * d) / (2 * (b - a)), 2d)
                )
                / 2;
    }

    public double getLongerBaseAge() {
        return longerBaseAge;
    }

    public double getShorterBaseAge() {
        return shorterBaseAge;
    }

    public double getLongerSide() {
        return longerSide;
    }

    public double getShorterSide() {
        return shorterSide;
    }
}
