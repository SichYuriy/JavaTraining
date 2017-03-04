package com.gmail.at.sichyuriyy.javatraining.homework3.task17;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 04.03.2017.
 */
public class CalculatorTest {

    private static final double DELTA = 10e-7;

    @Test
    public void calculate() throws Exception {
        String input = "3+4";
        Double expected = 7d;
        Calculator calculator = new Calculator();
        Double actual = calculator.calculate(input);

        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculateWithBraces() throws Exception {
        String input = "(3+3)*4";
        Double expected = 24d;
        Calculator calculator = new Calculator();
        Double actual = calculator.calculate(input);

        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculateWithPrecedence() throws Exception {
        String input = "3+3*4";
        Double expected = 15d;
        Calculator calculator = new Calculator();
        Double actual = calculator.calculate(input);

        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculateBigExpression() throws Exception {
        String input = "3 + 4 * 2 / (1 - 5) * 2 + 3";
        Double expected = 2d;
        Calculator calculator = new Calculator();
        Double actual = calculator.calculate(input);

        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculateUnoOperator() throws Exception {
        String input = "-3 + 4 * 2 / (1 - 5) * 2 + 3";
        Double expected = -4d;
        Calculator calculator = new Calculator();
        Double actual = calculator.calculate(input);

        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculateWithDouble() throws Exception {
        String input = "1.5 + 3.5";
        Double expected = 5d;
        Calculator calculator = new Calculator();
        Double actual = calculator.calculate(input);

        assertEquals(expected, actual, DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateWithBadDouble() throws Exception {
        String input = "1.5 + 3.5.2";
        Calculator calculator = new Calculator();
        calculator.calculate(input);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateWithBadSymbol() throws Exception {
        String input = "1.5 + 3q";
        Calculator calculator = new Calculator();
        calculator.calculate(input);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateWithBadBeginBraces() throws Exception {
        String input = "1 + (1 + 2";
        Calculator calculator = new Calculator();
        calculator.calculate(input);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateWithBadEndBraces() throws Exception {
        String input = "1 + 2) + 3";
        Calculator calculator = new Calculator();
        calculator.calculate(input);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateWithDoubleOperator() throws Exception {
        String input = "1+*2";
        Calculator calculator = new Calculator();
        calculator.calculate(input);
    }







}