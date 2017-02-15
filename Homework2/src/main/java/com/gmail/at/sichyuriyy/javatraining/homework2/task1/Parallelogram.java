package com.gmail.at.sichyuriyy.javatraining.homework2.task1;

/**
 * Created by Yuriy on 13.02.2017.
 */
public class Parallelogram implements Shape {

    private double firstSide;
    private double secondSide;
    private double phi;

    private Parallelogram(double firstSide, double secondSide, double phi) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.phi = phi;
    }

    public static Parallelogram getParallelogram(double firstSide, double secondSide,
                                                 double phi) {
        if (firstSide <= 0 || secondSide <= 0) {
            throw new IllegalArgumentException("sides must be positive numbers");
        }
        if (phi <= 0 || phi >= Math.PI) {
            throw new IllegalArgumentException("phi must be between 0 and PI");
        }
        return new Parallelogram(firstSide, secondSide, phi);

    }

    @Override
    public double getArea() {
        return firstSide * secondSide * Math.sin(phi);
    }

    public double getFirstSide() {
        return firstSide;
    }

    public double getSecondSide() {
        return secondSide;
    }

    public double getPhi() {
        return phi;
    }
}
