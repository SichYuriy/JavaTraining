package com.gmail.at.sichyuriyy.javatraining.homework1;

import java.math.BigInteger;

/**
 * Created by Yuriy on 31.01.2017.
 */
public class KaratsubaMultiplier {

    public BigInteger karaMultiply(BigInteger x, BigInteger y) {
        if (x.equals(BigInteger.ZERO)
                || y.equals(BigInteger.ZERO)) {
            return BigInteger.ZERO;
        }

        int shiftLength = Math.max(x.bitLength(), y.bitLength()) / 2;

        if (shiftLength == 0) {
            return x.multiply(y);
        }

        BigInteger a = x.shiftRight(shiftLength);
        BigInteger b = x.subtract(a.shiftRight(shiftLength));
        BigInteger c = y.shiftRight(shiftLength);
        BigInteger d = y.subtract(c.shiftLeft(shiftLength));

        BigInteger productAC = karaMultiply(a, c);
        BigInteger productBD = karaMultiply(b, d);
        BigInteger productABCD = karaMultiply(a.add(b), c.add(d));

        return productAC.shiftLeft(shiftLength << 1)
                .add(productBD)
                .add(productABCD.subtract(productAC.add(productBD))
                        .shiftLeft(shiftLength));
    }

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

        int shiftLength = Math.max(lengthX, lengthY) / 2;

        if (shiftLength == 0) {
            return x & y;
        }

        long a = x >> shiftLength;
        long b = x & (~(a << shiftLength));
        long c = y >> shiftLength;
        long d = y & (~(c << shiftLength));

        long productAC = karaMultiply(a, c);
        long productBD = karaMultiply(b, d);
        long productABCD = karaMultiply(a + b, c + d);

        long result = (productAC << (shiftLength << 1))
                + productBD +
                ((productABCD - (productAC + productBD)) << shiftLength);

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
