package com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher.impl;

import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher.RsaCipher;
import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher.RsaPrivateKey;
import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher.RsaPublicKey;
import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.exception.GreaterThenModulusException;
import com.sun.istack.internal.NotNull;

import java.math.BigInteger;
import java.util.Objects;

/**
 * Created by Yuriy on 01.02.2017.
 */
public class RsaCipherImpl implements RsaCipher {


    @Override
    public byte[] encrypt(byte[] data, RsaPublicKey key) {

        Objects.requireNonNull(data);
        Objects.requireNonNull(key);

        BigInteger bigData = new BigInteger(data);

        if (bigData.bitLength() > key.getModulus().bitLength()) {
            throw new GreaterThenModulusException();
        }

        BigInteger decryptedBigData =
                bigData.modPow(key.getPublicExponent(), key.getModulus());

        return decryptedBigData.toByteArray();
    }

    @Override
    public byte[] decrypt(byte[] data, RsaPrivateKey key) {

        Objects.requireNonNull(data);
        Objects.requireNonNull(key);

        BigInteger bigData = new BigInteger(data);

        if (bigData.bitLength() > key.getModulus().bitLength()) {
            throw new GreaterThenModulusException();
        }

        BigInteger decryptedBigData =
                bigData.modPow(key.getPrivateExponent(), key.getModulus());

        return decryptedBigData.toByteArray();
    }
}
