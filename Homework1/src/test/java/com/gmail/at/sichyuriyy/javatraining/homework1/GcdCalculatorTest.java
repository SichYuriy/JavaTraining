package com.gmail.at.sichyuriyy.javatraining.homework1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 02.02.2017.
 */
public class GcdCalculatorTest {

    private GcdCalculator calculator = new GcdCalculator();

    @Test
    public void calculateGcd() throws Exception {
        long x = 56;
        long y = 32;
        long actual = calculator.calculateGcd(x, y);
        long expected = 8;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateGcd_resultOne() {
        long x = 13;
        long y = 53;
        long actual = calculator.calculateGcd(x, y);
        long expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateGcd_multipleNumbers() {
        long x = 25;
        long y = 50;
        long actual = calculator.calculateGcd(x, y);
        long expected = 25;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateGcd_oneNegative() {
        long x = -15;
        long y = 25;
        long actual = calculator.calculateGcd(x, y);
        long expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateGcd_bothNegative() {
        long x = -15;
        long y = -25;
        long actual = calculator.calculateGcd(x, y);
        long expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateGcd_oneMinValueXOtherEven() {
        long x = Long.MIN_VALUE;
        long y = 5660;
        long actual = calculator.calculateGcd(x, y);
        long expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateGcd_oneMinValueYOtherEven() {
        long y = Long.MIN_VALUE;
        long x = 5660;
        long actual = calculator.calculateGcd(x, y);
        long expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateGcd_oneMinValueOtherOdd() {
        long x = Long.MIN_VALUE;
        long y = 5661;
        long actual = calculator.calculateGcd(x, y);
        long expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateGcd_bothMinValue() {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;
        long actual = calculator.calculateGcd(x, y);
        long expected = Long.MIN_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateGcd_zero() {
        long x = 1234;
        long y = 0;
        long actual = calculator.calculateGcd(x, y);
        long expected = 1234;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateGcd_zeroZero() {
        long x = 0;
        long y = 0;
        long actual = calculator.calculateGcd(x, y);
        long expected = 0;
        assertEquals(expected, actual);
    }




}