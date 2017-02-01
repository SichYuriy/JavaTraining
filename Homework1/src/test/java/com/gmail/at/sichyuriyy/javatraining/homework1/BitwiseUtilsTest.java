package com.gmail.at.sichyuriyy.javatraining.homework1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 01.02.2017.
 */
public class BitwiseUtilsTest {

    @Test
    public void countBitLengthOfByte() {
        int actual = BitwiseUtils.countBitLengthOfByte();
        int expected = 8;
        assertEquals(expected, actual);
    }

    @Test
    public void countBitLengthOfShort() {
        int actual = BitwiseUtils.countBitLengthOfShort();
        int expected = 16;
        assertEquals(expected, actual);
    }

    @Test
    public void countBitLengthOfInt() {
        int actual = BitwiseUtils.countBitLengthOfInt();
        int expected = 32;
        assertEquals(expected, actual);
    }

    @Test
    public void countBitLengthOfLong() {
        int actual = BitwiseUtils.countBitLengthOfLong();
        int expected = 64;
        assertEquals(expected, actual);
    }

    @Test
    public void setBitZero() {
        int number = 9;
        int pos = 4;
        int actual = BitwiseUtils.setBitZero(number, pos);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setBitZero_outOfMinBound() {
        int number = 9;
        int badPos = 0;
        int actual = BitwiseUtils.setBitZero(number, badPos);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setBitZero_outOfMaxBound() {
        int number = 9;
        int badPos = 33;
        int actual = BitwiseUtils.setBitZero(number, badPos);
    }

    @Test
    public void setBitOne() {
        int number = 9;
        int pos = 2;
        int actual = BitwiseUtils.setBitOne(number, pos);
        int expected = 11;
        assertEquals(expected, actual);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setBitOne_outOfMinBound() {
        int number = 9;
        int badPos = 0;
        int actual = BitwiseUtils.setBitOne(number, badPos);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setBitOne_outOfMaxBound() {
        int number = 9;
        int badPos = 33;
        int actual = BitwiseUtils.setBitOne(number, badPos);
    }

}