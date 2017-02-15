package com.gmail.at.sichyuriyy.javatraining.homework2.task1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 13.02.2017.
 */
public class RingTest {

    private static final double DELTA = 10e-7;

    @Test
    public void getRing() {
        double radius = 3;
        Ring ring = Ring.getRing(radius);
        assertEquals(radius, ring.getRadius(), DELTA);
    }

    @Test
    public void getArea() {
        double radius = 3;
        Ring ring = Ring.getRing(radius);
        double expectedArea = 28.274333882308139146163790449516;
        double actualArea = ring.getArea();
        assertEquals(radius, ring.getRadius(), DELTA);
    }

    @Test
    public void plusParallelogram() {
        Ring ring = Ring.getRing(2);
        Parallelogram parallelogram = Parallelogram.getParallelogram(2, 3,
                Math.PI / 6);
        double expectedArea = 15.566370614359172953850573533118;
        double actualArea = ring.plus(parallelogram);
        assertEquals(expectedArea, actualArea, DELTA);
    }

    @Test
    public void plusRing() {
        Ring firstRing = Ring.getRing(2);
        Ring secondRing = Ring.getRing(3);
        double expectedArea = 40.840704496667312100014363982634;
        double actualArea = firstRing.plus(secondRing);
        assertEquals(expectedArea, actualArea, DELTA);
    }

    @Test
    public void plusTrapezium() {
        Ring ring = Ring.getRing(3);
        Trapezium trapezium = Trapezium.getTrapezium(6, 3, 5, 4);
        double expectedArea = 46.274333882308139146163790449516;
        double actualArea = ring.plus(trapezium);
        assertEquals(expectedArea, actualArea, DELTA);
    }

    @Test
    public void plusTriangle() {
        Ring ring = Ring.getRing(3);
        Triangle triangle = Triangle.getTriangle(3, 4, 5);
        double expectedArea = 34.274333882308139146163790449516;
        double actualArea = ring.plus(triangle);
        assertEquals(expectedArea, actualArea, DELTA);
    }

    /**
     * testing creating ring with negative radius
     */
    @Test(expected = IllegalArgumentException.class)
    public void getRingNegativeRadius() {
        double negativeRadius = -2;
        Ring.getRing(negativeRadius);
    }
}