package com.gmail.at.sichyuriyy.javatraining.homework2.task1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 13.02.2017.
 */
public class ParallelogramTest {

    private static final double DELTA = 10e-7;

    @Test
    public void getParallelogram() {
        double firstSide = 2;
        double secondSide = 3;
        double phi = Math.PI / 6;
        Parallelogram parallelogram = Parallelogram.getParallelogram(firstSide,
                secondSide, phi);
        assertEquals(firstSide, parallelogram.getFirstSide(), DELTA);
        assertEquals(secondSide, parallelogram.getSecondSide(), DELTA);
        assertEquals(phi, parallelogram.getPhi(), DELTA);

    }

    @Test
    public void getArea() {
        double firstSide = 2;
        double secondSide = 3;
        double phi = Math.PI / 6;
        Parallelogram parallelogram = Parallelogram.getParallelogram(firstSide,
                secondSide, phi);
        double delta = 10e-7;
        double expectedArea = 3;
        double actualArea = parallelogram.getArea();
        assertEquals(expectedArea, actualArea, delta);
    }

    @Test
    public void plusParallelogram() {
        Parallelogram firstParallelogram = Parallelogram.getParallelogram(2, 3,
                Math.PI / 6);
        Parallelogram secondParallelogram = Parallelogram.getParallelogram(4, 5,
                Math.PI / 3);
        double expectedArea = 20.320508075688772935274463415059;
        double actualArea = firstParallelogram.plus(secondParallelogram);
        assertEquals(expectedArea, actualArea, DELTA);
    }

    @Test
    public void plusRing() throws Exception {
        Parallelogram parallelogram = Parallelogram.getParallelogram(2, 3,
                Math.PI / 6);
        Ring ring = Ring.getRing(2);
        double expectedArea = 15.566370614359172953850573533118;
        double actualArea = parallelogram.plus(ring);
        assertEquals(expectedArea, actualArea, DELTA);
    }

    @Test
    public void plusTrapezium() throws Exception {
        Parallelogram parallelogram = Parallelogram.getParallelogram(2, 3,
                Math.PI / 6);
        Trapezium trapezium = Trapezium.getTrapezium(6, 3, 5, 4);
        double expectedArea = 21;
        double actualArea = parallelogram.plus(trapezium);
        assertEquals(expectedArea, actualArea, DELTA);
    }

    @Test
    public void plusTriangle() throws Exception {
        Parallelogram parallelogram = Parallelogram.getParallelogram(2, 3,
                Math.PI / 6);
        Triangle triangle = Triangle.getTriangle(3, 4, 5);
        double expectedArea = 9;
        double actualArea = parallelogram.plus(triangle);
        assertEquals(expectedArea, actualArea, DELTA);
    }

    /**
     * testing parallelogram creation with negative side
     */
    @Test(expected = IllegalArgumentException.class)
    public void getTriangleNegativeSide() {
        double firstSide = 2;
        double negativeSecondSide = -3;
        double phi = Math.PI / 6;
        Parallelogram parallelogram = Parallelogram.getParallelogram(firstSide,
                negativeSecondSide, phi);
    }

    /**
     * testing parallelogram creation with negative angle phi
     */
    @Test(expected = IllegalArgumentException.class)
    public void getTriangleNegativeAngle() {
        double firstSide = 2;
        double secondSide = 3;
        double phi = -Math.PI / 6;
        Parallelogram parallelogram = Parallelogram.getParallelogram(firstSide,
                secondSide, phi);
    }
}