package com.gmail.at.sichyuriyy.javatraining.homework1.rsa.util;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 06.02.2017.
 */
public class MathUtilsTest {

    @Test
    public void isPrime_prime() {
        BigInteger prime = BigInteger.valueOf(23);
        assertTrue(MathUtils.isPrime(prime));

    }

    @Test
    public void isPrime_notPrimeEven() {
        BigInteger notPrime = BigInteger.valueOf(22);
        assertFalse(MathUtils.isPrime(notPrime));
    }

    @Test
    public void isPrime_notPrimeOdd() {
        BigInteger notPrime = BigInteger.valueOf(81);
        assertFalse(MathUtils.isPrime(notPrime));
    }



    @Test(expected = IllegalArgumentException.class)
    public void isPrime_negative() {
        BigInteger negative = BigInteger.valueOf(-2);
        MathUtils.isPrime(negative);
    }

    @Test
    public void isPrime_one() {
        BigInteger one = BigInteger.ONE;
        assertFalse(MathUtils.isPrime(one));
    }
}