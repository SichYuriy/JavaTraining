package com.gmail.at.sichyuriyy.javatraining.homework1.rsa.keygenerator.impl;

import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher.RsaPrivateKey;
import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher.RsaPublicKey;
import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.keygenerator.KeyPair;

/**
 * Created by Yuriy on 02.02.2017.
 */
public class KeyPairImpl implements KeyPair {

    private RsaPublicKey publicKey;
    private RsaPrivateKey privateKey;

    public KeyPairImpl(RsaPublicKey publicKey, RsaPrivateKey privateKey) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
    }

    @Override
    public RsaPublicKey getPublicKey() {
        return this.publicKey;
    }

    @Override
    public RsaPrivateKey getPrivateKey() {
        return this.privateKey;
    }

    public void setPublicKey(RsaPublicKey publicKey) {
        this.publicKey = publicKey;
    }

    public void setPrivateKey(RsaPrivateKey privateKey) {
        this.privateKey = privateKey;
    }
}
