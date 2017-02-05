package com.gmail.at.sichyuriyy.javatraining.homework1.rsa.util;

import java.math.BigInteger;

/**
 * Created by Yuriy on 04.02.2017.
 */
public class MathUtils {

    private MathUtils() {
    }

    public static boolean isPrime(BigInteger number) {
        if (number.signum() < 0) {
            throw new IllegalArgumentException();
        }
        if (number.equals(BigInteger.ONE)) {
            return false;
        }

        BigInteger two = new BigInteger("2");
        if (!two.equals(number) && BigInteger.ZERO.equals(number.mod(two)))
            return false;

        for (BigInteger i = new BigInteger("3"); i.multiply(i).compareTo(number) < 1; i = i.add(two)) {
            if (BigInteger.ZERO.equals(number.mod(i)))
                return false;
        }
        return true;

    }
}
