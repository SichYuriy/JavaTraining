package com.gmail.at.sichyuriyy.javatraining.homework1;

import static com.gmail.at.sichyuriyy.javatraining.homework1.BitwiseUtils.abs;
/**
 * Created by Yuriy on 01.02.2017.
 */
public class GcdCalculator {

    long calculateGcd(long x, long y) {
        if (x == Long.MIN_VALUE && y == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        } else if (x == Long.MIN_VALUE) {
            calculateGcdOfLongMinValue(x, y);
        } else if (y == Long.MIN_VALUE) {
            calculateGcdOfLongMinValue(y, x);
        }
        x = abs(x);
        y = abs(y);
        return calculateGcdRecursively(x, y);

    }

    private long calculateGcdRecursively(long x, long y) {
        if (x == y)
            return x;
        if (x == 0)
            return y;
        if (y == 0)
            return x;

        if ((~x & 1) != 0) { // x is even
            if ((y & 1) != 0) { // y is odd
                return calculateGcd(x >> 1, y);
            } else {
                return calculateGcd(x >> 1, y >> 1) << 1;
            }
        }
        if ((~y & 1) != 0) { // y is even
            return calculateGcd(x, y >> 1);
        }

        if (x > y) {
            return calculateGcd((x - y) >> 1, y);
        }
        return calculateGcd((y - x) >> 1, x);
    }

    private long calculateGcdOfLongMinValue(long minValue, long otherValue) {
        if ((otherValue & 1) != 0) { // is odd
            long x = abs(minValue >> 1);
            long y = abs(otherValue);
            return calculateGcdRecursively(x, y);
        } else {
            long x = abs(minValue >> 1);
            long y = abs(otherValue >> 1);
            return calculateGcdRecursively(x, y) << 1;
        }
    }



}
