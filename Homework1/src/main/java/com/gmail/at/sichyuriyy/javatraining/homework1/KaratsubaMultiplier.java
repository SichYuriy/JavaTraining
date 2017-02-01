package com.gmail.at.sichyuriyy.javatraining.homework1;

/**
 * Created by Yuriy on 31.01.2017.
 */
public class KaratsubaMultiplier {

    public long karaMultiply(long x, long y) {
        if (x == 0 || y == 0) {
            return 0;
        }

        boolean negative = false;
        if ((x > 0 && y < 0)
                || (x < 0 && y > 0)) {
            negative = true;
        }
        x = Math.abs(x);
        y = Math.abs(y);

        int lengthX = getBitLength(x);
        int lengthY = getBitLength(y);

        int divLength = Math.max(lengthX, lengthY) / 2;

        if (divLength == 0) {
            return x * y;
        }

        long a = x >> divLength;
        long b = x & (~(a << divLength));
        long c = y >> divLength;
        long d = y & (~(c << divLength));

        long productAC = karaMultiply(a, c);
        long productBD = karaMultiply(b, d);
        long productABCD = karaMultiply(a + b, c + d);

        long result = (productAC << (divLength * 2))
                + productBD +
                ((productABCD - (productAC + productBD)) << divLength);

        if (negative) {
            result = -result;
        }
        return result;
    }

    private int getBitLength(long number) {
        int length = 0;
        while (number != 0) {
            number = number >> 1;
            length++;
        }
        return length;
    }

}
