package com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher.impl;

import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher.RsaCipher;
import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher.RsaPrivateKey;
import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher.RsaPublicKey;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by Yuriy on 01.02.2017.
 */
public class RsaCipherImpl implements RsaCipher {

    private static final int MODULUS_MIN_LENGTH = 9;


    @Override
    public byte[] encrypt(byte[] data, RsaPublicKey key) {

        if (data == null) {
            return new byte[0];
        }
        if (key == null
                || key.getModulus() == null
                || key.getPublicExponent() == null) {
            throw new IllegalArgumentException("key must be not null");
        }
        if (key.getModulus().bitLength() < MODULUS_MIN_LENGTH) {
            throw new IllegalArgumentException("key modulus is to short");
        }

        int dataPartLength = calculateInputDataPartLength(key.getModulus());

        byte[][] dividedData = divideData(data, dataPartLength);

        int partsCount = dividedData.length;
        int lastPartLength = dividedData[partsCount - 1].length;

        byte[][] encryptedParts = new byte[partsCount + 1][];
        for (int i = 0; i < partsCount; i++) {
            encryptedParts[i] = encryptPart(dividedData[i], key);
        }
        byte[] signature = BigInteger.valueOf(lastPartLength).toByteArray();
        encryptedParts[partsCount] = encryptPart(signature, key);

        int finalPartSize = calculateOutputDataPartLength(key.getModulus());

        byte[][] expandedParts = expandParts(encryptedParts,
                encryptedParts.length, finalPartSize);

        return concatParts(expandedParts);
    }

    @Override
    public byte[] decrypt(byte[] data, RsaPrivateKey key) {
        if (data == null) {
            return new byte[0];
        }
        if (key == null
                || key.getModulus() == null
                || key.getPrivateExponent() == null) {
            throw new IllegalArgumentException("key must be not null");
        }
        if (key.getModulus().bitLength() < MODULUS_MIN_LENGTH) {
            throw new IllegalArgumentException("key modulus is to short");
        }

        int dataPartLength = calculateOutputDataPartLength(key.getModulus());

        byte[][] dividedData = divideData(data, dataPartLength);

        int partsCount = dividedData.length - 1;

        byte[][] decryptedParts = new byte[partsCount][];
        for (int i = 0; i < partsCount; i++) {
            decryptedParts[i] = decryptPart(dividedData[i], key);
        }

        int finalPartSize = calculateInputDataPartLength(key.getModulus());
        byte[][] expandedParts = expandParts(decryptedParts,
                partsCount - 1,
                finalPartSize);

        int signature = new BigInteger(decryptPart(dividedData[dividedData.length - 1], key)).intValue();
        expandedParts[partsCount - 1] = expandData(decryptedParts[partsCount - 1], signature);

        return concatParts(expandedParts);

    }

    private byte[][] divideData(byte[] data, int dataPartLength) {
        int dataPartsCount = data.length / dataPartLength;
        if (data.length % dataPartLength != 0) {
            dataPartsCount++;
        }

        byte[][] result = new byte[dataPartsCount][];
        for (int i = 0; i < dataPartsCount; i++) {
            int from = i * dataPartLength;
            int to = Math.min(data.length, (i + 1) * dataPartLength);
            result[i] = Arrays.copyOfRange(data, from, to);
        }
        return result;
    }

    private int calculateInputDataPartLength(BigInteger modulus) {
        return modulus.bitLength() / 8;
    }

    private int calculateOutputDataPartLength(BigInteger modulus) {
        return  modulus.bitLength() / 8 + 1;
    }

    private byte[] encryptPart(byte[] dataPart, RsaPublicKey key) {
        BigInteger bigData = new BigInteger(dataPart);
        BigInteger encryptedBigData =
                bigData.modPow(key.getPublicExponent(), key.getModulus());
        return encryptedBigData.toByteArray();
    }

    private byte[] decryptPart(byte[] dataPart, RsaPrivateKey key) {
        BigInteger bigData = new BigInteger(dataPart);
        BigInteger decryptedBigData =
                bigData.modPow(key.getPrivateExponent(), key.getModulus());
        return decryptedBigData.toByteArray();
    }

    private byte[] expandData(byte[] data, int length) {
        byte[] expendedData = new byte[length];
        System.arraycopy(data, 0, expendedData, length - data.length, data.length);
        return expendedData;
    }

    private byte[][] expandParts(byte[][] parts,
                                 int partsToExpandCount,
                                 int  finalPartSize) {
        byte[][] result = new byte[parts.length][];
        for (int i = 0; i < partsToExpandCount; i++) {
            result[i] = expandData(parts[i], finalPartSize);
        }
        return  result;
    }

    private byte[] concatParts(byte[][] parts) {
        int resultLength = 0;
        for (byte[] part : parts) {
            resultLength += part.length;
        }
        byte[] result = new byte[resultLength];
        int from = 0;
        for (byte[] part : parts) {
            System.arraycopy(part, 0, result, from, part.length);
            from += part.length;
        }

        return result;
    }


}
