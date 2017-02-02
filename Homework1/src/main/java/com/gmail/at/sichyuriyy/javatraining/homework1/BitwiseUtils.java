package com.gmail.at.sichyuriyy.javatraining.homework1;

/**
 * Created by Yuriy on 31.01.2017.
 */
public class BitwiseUtils {

    public static int countBitLengthOfByte() {
        byte byteNumber = 1;
        int length = 0;
        while (byteNumber != 0) {
            byteNumber = (byte) (byteNumber << 1);
            length++;
        }
        return length;
    }

    public static int countBitLengthOfShort() {
        short shortNumber = 1;
        int length = 0;
        while (shortNumber != 0) {
            shortNumber = (short) (shortNumber << 1);
            length++;
        }
        return length;
    }

    public static int countBitLengthOfInt() {
        int intNumber = 1;
        int length = 0;
        while (intNumber != 0) {
            intNumber = intNumber << 1;
            length++;
        }
        return length;
    }

    public static int countBitLengthOfLong() {
        long longNumber = 1;
        int length = 0;
        while (longNumber != 0) {
            longNumber = longNumber << 1;
            length++;
        }
        return length;
    }

    public static int setBitZero(int number, int pos) {
        if (pos <= 0 || pos > 32) {
            throw new IndexOutOfBoundsException();
        }
        return number & (~(1 << (pos - 1)));
    }

    public static int setBitOne(int number, int pos) {
        if (pos <= 0 || pos > 32) {
            throw new IndexOutOfBoundsException();
        }
        return number | (1 << (pos - 1));
    }

    public static long abs(long value) {
        if (value < 0) {
            return ~value + 1;
        }
        return value;
    }




}
