package com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher.impl;

import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher.RsaPublicKey;

import java.math.BigInteger;

/**
 * Created by Yuriy on 01.02.2017.
 */
public class RsaPublicKeyImpl implements RsaPublicKey {

    private BigInteger modulus;
    private BigInteger publicExponent;

    public RsaPublicKeyImpl(BigInteger modulus, BigInteger publicExponent) {
        this.modulus = modulus;
        this.publicExponent = publicExponent;
    }

    @Override
    public BigInteger getModulus() {
        return this.modulus;
    }

    @Override
    public BigInteger getPublicExponent() {
        return this.publicExponent;
    }

    public void setModules(BigInteger modulus) {
        this.modulus = modulus;
    }

    public void setPublicExponent(BigInteger publicExponent) {
        this.publicExponent = publicExponent;
    }

}
