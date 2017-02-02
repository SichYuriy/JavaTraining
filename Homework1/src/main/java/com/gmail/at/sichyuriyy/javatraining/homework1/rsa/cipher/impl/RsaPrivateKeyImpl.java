package com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher.impl;

import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher.RsaPrivateKey;

import java.math.BigInteger;

/**
 * Created by Yuriy on 01.02.2017.
 */
public class RsaPrivateKeyImpl implements RsaPrivateKey {

    private BigInteger modulus;
    private BigInteger privateExponent;

    public RsaPrivateKeyImpl(BigInteger modulus, BigInteger privateExponent) {
        this.modulus = modulus;
        this.privateExponent = privateExponent;
    }

    @Override
    public BigInteger getModulus() {
        return this.modulus;
    }

    @Override
    public BigInteger getPrivateExponent() {
        return this.privateExponent;
    }

    public void setModules(BigInteger modulus) {
        this.modulus = modulus;
    }

    public void setPrivateExponent(BigInteger privateExponent) {
        this.privateExponent = privateExponent;
    }

}
