package com.gmail.at.sichyuriyy.javatraining.homework1;

import static com.gmail.at.sichyuriyy.javatraining.homework1.BitwiseUtils.abs;
/**
 * Created by Yuriy on 01.02.2017.
 */
public class GcdCalculator {

    /**
     * @param x first param
     * @param y second param
     * @return <p><b>gcd</b> of params</p>
     *      <p><b>Long.MIN_VALUE</b> if both of params is equal Long.MIN_VALUE</p>
     */
    long calculateGcd(long x, long y) {
        if (x == Long.MIN_VALUE && y == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        } else if (x == Long.MIN_VALUE) {
            calculateGcdOfLongMinValue(x, y);
        } else if (y == Long.MIN_VALUE) {
            calculateGcdOfLongMinValue(y, x);
        }
        long positiveX = abs(x);
        long positiveY = abs(y);
        return calculateGcdRecursively(positiveX, positiveY);

    }

    /**
     * <p>algorithm notes:</p>
     * <ol>
     *     <li>if one of params is zero: gcd(0, b) = b</li>
     *     <li>if both params even numbers: gcd(a, b) = gcd(a / 2, b / 2) * 2</li>
     *     <li>if only one param(a) is even: gcd(a, b) = gcd(a / 2, b)</li>
     *     <li>if both params odd and a is bigger: gcd(a, b) = ((a - b) / 2, b)</li>
     * </ol>
     *
     * @param x first number
     * @param y second number
     * @return gcd of parameters
     */
    private long calculateGcdRecursively(long x, long y) {
        if (x == y)
            return x;
        if (x == 0 || y == 0)
            return Math.max(x, y);

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
            return 1;
        } else {
            long x = abs(minValue >> 1);
            long y = abs(otherValue >> 1);
            return calculateGcdRecursively(x, y) << 1;
        }
    }



}
