package com.gmail.at.sichyuriyy.javatraining.homework2.task1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 13.02.2017.
 */
public class TrapeziumTest {

    private static final double DELTA = 10e-7;

    @Test
    public void getTrapezium() {
        double longerBaseAge = 6;
        double shorterBaseAge = 3;
        double longerSide = 5;
        double shorterSide = 4;
        Trapezium trapezium = Trapezium.getTrapezium(longerBaseAge, shorterBaseAge,
                longerSide, shorterSide);
        assertEquals(longerBaseAge, trapezium.getLongerBaseAge(), DELTA);
        assertEquals(shorterBaseAge, trapezium.getShorterBaseAge(), DELTA);
        assertEquals(longerSide, trapezium.getLongerSide(), DELTA);
        assertEquals(shorterSide, trapezium.getShorterSide(), DELTA);

    }

    @Test
    public void getArea() {
        double longerBaseAge = 6;
        double shorterBaseAge = 3;
        double longerSide = 5;
        double shorterSide = 4;
        Trapezium trapezium = Trapezium.getTrapezium(longerBaseAge, shorterBaseAge,
                longerSide, shorterSide);
        double expectedArea = 18;
        double actualArea = trapezium.getArea();
        assertEquals(expectedArea, actualArea, DELTA);
    }

    @Test
    public void plusParallelogram() {
        Trapezium trapezium = Trapezium.getTrapezium(6, 3, 5, 4);
        Parallelogram parallelogram = Parallelogram.getParallelogram(2, 3,
                Math.PI / 6);
        double expectedArea = 21;
        double actualArea = trapezium.plus(parallelogram);
        assertEquals(expectedArea, actualArea, DELTA);
    }

    @Test
    public void plusRing() {
        Trapezium trapezium = Trapezium.getTrapezium(6, 3, 5, 4);
        Ring ring = Ring.getRing(3);
        double expectedArea = 46.274333882308139146163790449516;
        double actualArea = ring.plus(trapezium);
        assertEquals(expectedArea, actualArea, DELTA);
    }

    @Test
    public void plusTrapezium() {
        Trapezium firstTrapezium = Trapezium.getTrapezium(6, 3, 5, 4);
        Trapezium secondTrapezium = Trapezium.getTrapezium(5, 2, 5, 4);
        double expectedArea = 32;
        double actualArea = firstTrapezium.plus(secondTrapezium);
        assertEquals(expectedArea, actualArea, DELTA);
    }

    @Test
    public void plusTriangle() {
        Trapezium trapezium = Trapezium.getTrapezium(6, 3, 5, 4);
        Triangle triangle = Triangle.getTriangle(3, 4, 5);
        double expectedArea = 24;
        double actualArea = trapezium.plus(triangle);
        assertEquals(expectedArea, actualArea, DELTA);
    }

    /**
     * testing creating ring with negative radius
     */
    @Test(expected = IllegalArgumentException.class)
    public void getTrapeziumNegativeSide() {
        double longerBaseAge = 6;
        double shorterBaseAge = 3;
        double longerSide = -5;
        double shorterSide = 4;
        Trapezium trapezium = Trapezium.getTrapezium(longerBaseAge, shorterBaseAge,
                longerSide, shorterSide);
    }

    /**
     * testing trapezium creating with longerSide
     */
    @Test(expected = IllegalArgumentException.class)
    public void getTrapeziumBadLongerAndShorterSides() {
        double longerBaseAge = 3;
        double shorterBaseAge = 6;
        double longerSide = 5;
        double shorterSide = 4;
        Trapezium trapezium = Trapezium.getTrapezium(longerBaseAge, shorterBaseAge,
                longerSide, shorterSide);
    }

    /**
     * testing trapezium creating with equal baseAges
     */
    @Test(expected = IllegalArgumentException.class)
    public void getTrapeziumEqualBaseAges() {
        double longerBaseAge = 6;
        double shorterBaseAge = 6;
        double longerSide = 5;
        double shorterSide = 4;
        Trapezium trapezium = Trapezium.getTrapezium(longerBaseAge, shorterBaseAge,
                longerSide, shorterSide);
    }
}