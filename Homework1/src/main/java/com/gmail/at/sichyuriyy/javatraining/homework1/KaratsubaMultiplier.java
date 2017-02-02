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
        
        int negative = x.signum() * y.signum();
        BigInteger absX = x.abs();
        BigInteger absY = y.abs();

        int shiftLength = Math.max(absX.bitLength(), absY.bitLength()) / 2;

        if (shiftLength == 0) {
            return absX.multiply(y);
        }

        BigInteger a = absX.shiftRight(shiftLength);
        BigInteger b = absX.andNot(a.shiftLeft(shiftLength));
        BigInteger c = absY.shiftRight(shiftLength);
        BigInteger d = absY.andNot(c.shiftLeft(shiftLength));

        BigInteger productAC = karaMultiply(a, c);
        BigInteger productBD = karaMultiply(b, d);
        BigInteger productABCD = karaMultiply(a.add(b), c.add(d));

        return productAC.shiftLeft(shiftLength << 1)
                .add(productBD)
                .add(productABCD.subtract(productAC.add(productBD))
                        .shiftLeft(shiftLength))
                .multiply(BigInteger.valueOf(negative));
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
        long absX = BitwiseUtils.abs(x);
        long absY = BitwiseUtils.abs(y);

        int lengthX = getBitLength(absX);
        int lengthY = getBitLength(absY);

        int shiftLength = Math.max(lengthX, lengthY) / 2;

        if (shiftLength == 0) {
            return absX & absY;
        }

        long a = absX >> shiftLength;
        long b = absX & (~(a << shiftLength));
        long c = absY >> shiftLength;
        long d = absY & (~(c << shiftLength));

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
            number >>= 1;
            length++;
        }
        return length;
    }

}
