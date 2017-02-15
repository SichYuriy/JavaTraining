package com.gmail.at.sichyuriyy.javatraining.homework2.task1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 13.02.2017.
 */
public class TriangleTest {

    private static final double DELTA = 10e-7;

    @Test
    public void getTriangle() throws Exception {
        double firstSide = 3;
        double secondSide = 4;
        double thirdSide = 5;
        Triangle triangle = Triangle.getTriangle(firstSide, secondSide, thirdSide);
        assertEquals(firstSide, triangle.getFirstSide(), DELTA);
        assertEquals(secondSide, triangle.getSecondSide(), DELTA);
        assertEquals(thirdSide, triangle.getThirdSide(), DELTA);
    }

    @Test
    public void getArea() throws Exception {
        double firstSide = 3;
        double secondSide = 4;
        double thirdSide = 5;
        Triangle triangle = Triangle.getTriangle(firstSide, secondSide, thirdSide);
        double expectedArea = 6;
        double actualArea = triangle.getArea();
        assertEquals(expectedArea, actualArea, DELTA);
    }

    @Test
    public void plusParallelogram() {
        Triangle triangle = Triangle.getTriangle(3, 4, 5);
        Parallelogram parallelogram = Parallelogram.getParallelogram(2, 3,
                Math.PI / 6);
        double expectedArea = 9;
        double actualArea = triangle.plus(parallelogram);
        assertEquals(expectedArea, actualArea, DELTA);
    }

    @Test
    public void plusRing() {
        Triangle triangle = Triangle.getTriangle(3, 4, 5);
        Ring ring = Ring.getRing(3);
        double expectedArea = 34.274333882308139146163790449516;
        double actualArea = triangle.plus(ring);
        assertEquals(expectedArea, actualArea, DELTA);
    }

    @Test
    public void plusTrapezium() {
        Triangle triangle = Triangle.getTriangle(3, 4, 5);
        Trapezium trapezium = Trapezium.getTrapezium(5, 2, 5, 4);
        double expectedArea = 20;
        double actualArea = triangle.plus(trapezium);
        assertEquals(expectedArea, actualArea, DELTA);
    }

    @Test
    public void plusTriangle() {
        Triangle firstTriangle = Triangle.getTriangle(3, 4, 5);
        Triangle secondTriangle = Triangle.getTriangle(3, 4, 5);
        double expectedArea = 12;
        double actualArea = firstTriangle.plus(secondTriangle);
        assertEquals(expectedArea, actualArea, DELTA);
    }

    /**
     * testing triangle creation with negative side
     */
    @Test(expected = IllegalArgumentException.class)
    public void getTriangleNegativeSide() {
        double firstSide = 3;
        double secondSide = -4;
        double thirdSide = 5;
        Triangle triangle = Triangle.getTriangle(firstSide, secondSide, thirdSide);
    }

    /**
     * testing triangle creation with impossible sides
     */
    @Test(expected = IllegalArgumentException.class)
    public void getTriangleBadSides() {
        double firstSide = 3;
        double secondSide = 4;
        double thirdSide = 10;
        Triangle triangle = Triangle.getTriangle(firstSide, secondSide, thirdSide);
    }
}