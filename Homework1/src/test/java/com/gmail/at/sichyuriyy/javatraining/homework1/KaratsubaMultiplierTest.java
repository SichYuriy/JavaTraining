package com.gmail.at.sichyuriyy.javatraining.homework1;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 02.02.2017.
 */
public class KaratsubaMultiplierTest {

    private KaratsubaMultiplier multiplier = new KaratsubaMultiplier();

    @Test
    public void karaMultiplyLong() {
        long x = 1023;
        long y = 7829;
        long actual = multiplier.karaMultiply(x, y);
        long expected = 8009067;
        assertEquals(expected, actual);

    }

    @Test
    public void karaMultiplyLong_oneNegative() {
        long x = 1023;
        long y = -7829;
        long actual = multiplier.karaMultiply(x, y);
        long expected = -8009067;
        assertEquals(expected, actual);

    }

    @Test
    public void karaMultiplyLong_bothNegative() {
        long x = -1023;
        long y = -7829;
        long actual = multiplier.karaMultiply(x, y);
        long expected = 8009067;
        assertEquals(expected, actual);

    }

    @Test
    public void karaMultiplyLong_zero() {
        long x = 1023;
        long y = 0;
        long actual = multiplier.karaMultiply(x, y);
        long expected = 0;
        assertEquals(expected, actual);

    }

    @Test
    public void karaMultiplyLong_zeroZero() {
        long x = 0;
        long y = 0;
        long actual = multiplier.karaMultiply(x, y);
        long expected = 0;
        assertEquals(expected, actual);

    }

    @Test
    public void karaMultiplyBigInteger() {
        BigInteger x = new BigInteger("1023", 10);
        BigInteger y = new BigInteger("7829", 10);
        BigInteger actual = multiplier.karaMultiply(x, y);
        BigInteger expected = new BigInteger("8009067", 10);
        assertEquals(expected, actual);

    }

    @Test
    public void karaMultiplyBigInteger_oneNegative() {
        BigInteger x = new BigInteger("1023", 10);
        BigInteger y = new BigInteger("-7829", 10);
        BigInteger actual = multiplier.karaMultiply(x, y);
        BigInteger expected = new BigInteger("-8009067", 10);
        assertEquals(expected, actual);

    }

    @Test
    public void karaMultiplyBigInteger_bothNegative() {
        BigInteger x = new BigInteger("-1023", 10);
        BigInteger y = new BigInteger("-7829", 10);
        BigInteger actual = multiplier.karaMultiply(x, y);
        BigInteger expected = new BigInteger("8009067", 10);
        assertEquals(expected, actual);

    }

    @Test
    public void karaMultiplyBigInteger_zero() {
        BigInteger x = new BigInteger("1023", 10);
        BigInteger y = BigInteger.ZERO;
        BigInteger actual = multiplier.karaMultiply(x, y);
        BigInteger expected = BigInteger.ZERO;
        assertEquals(expected, actual);

    }

    @Test
    public void karaMultiplyBigInteger_zeroZero() {
        BigInteger x = BigInteger.ZERO;
        BigInteger y = BigInteger.ZERO;
        BigInteger actual = multiplier.karaMultiply(x, y);
        BigInteger expected = BigInteger.ZERO;
        assertEquals(expected, actual);

    }

}