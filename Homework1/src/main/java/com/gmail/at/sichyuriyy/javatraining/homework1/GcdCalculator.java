package com.gmail.at.sichyuriyy.javatraining.homework1;

/**
 * Created by Yuriy on 01.02.2017.
 */
public class GcdCalculator {

    long calculateGcd(long x, long y) {
        x = Math.abs(x);
        y = Math.abs(y);
        if (x == y)
            return x;

        if (x == 0)
            return y;

        if (y == 0)
            return x;

        if ((~x & 1) != 0) {
            if ((y & 1) != 0) {
                return calculateGcd(x >> 1, y);
            } else {
                return calculateGcd(x >> 1, y >> 1) << 1;
            }
        }

        if ((~y & 1) != 0) {
            return calculateGcd(x, y >> 1);
        }

        if (x > y) {
            return calculateGcd((x - y) >> 1, y);
        }

        return calculateGcd((y - x) >> 1, x);
    }

}
