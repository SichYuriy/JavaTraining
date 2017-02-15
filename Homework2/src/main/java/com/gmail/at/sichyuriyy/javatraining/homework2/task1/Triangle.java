package com.gmail.at.sichyuriyy.javatraining.homework2.task1;

/**
 * Created by Yuriy on 13.02.2017.
 */
public class Triangle implements Shape {

    private double firstSide;
    private double secondSide;
    private double thirdSide;

    private Triangle(double firstSide, double secondSide, double thirdSide) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
    }

    public static Triangle getTriangle(double firstSide, double secondSide,
                                       double thirdSide) {
        if (firstSide <= 0 || secondSide <= 0 || thirdSide <= 0) {
            throw new IllegalArgumentException("sides must be positive numbers");
        }
        if (firstSide + secondSide <= thirdSide
                || firstSide + thirdSide <= secondSide
                || secondSide + thirdSide <= firstSide) {
            throw new IllegalArgumentException("a + b < c");
        }
        return new Triangle(firstSide, secondSide, thirdSide);
    }

    @Override
    public double getArea() {
        double a = firstSide;
        double b = secondSide;
        double c = thirdSide;
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public double getFirstSide() {
        return firstSide;
    }

    public double getSecondSide() {
        return secondSide;
    }

    public double getThirdSide() {
        return thirdSide;
    }
}
