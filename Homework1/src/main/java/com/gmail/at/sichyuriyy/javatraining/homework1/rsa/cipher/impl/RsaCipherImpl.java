package com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher.impl;

import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher.RsaCipher;
import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher.RsaPrivateKey;
import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher.RsaPublicKey;

import java.math.BigInteger;

/**
 * Created by Yuriy on 01.02.2017.
 */
public class RsaCipherImpl implements RsaCipher {


    @Override
    public byte[] encrypt(byte[] data, RsaPublicKey key) {
        BigInteger bigData = new BigInteger(data);

        BigInteger encryptedBigData =
                bigData.modPow(key.getPublicExponent(), key.getModulus());

        return encryptedBigData.toByteArray();
    }

    @Override
    public byte[] decrypt(byte[] data, RsaPrivateKey key) {
        BigInteger bigData = new BigInteger(data);

        BigInteger decryptedBigData =
                bigData.modPow(key.getPrivateExponent(), key.getModulus());

        return decryptedBigData.toByteArray();
    }
}
