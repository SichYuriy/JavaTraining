package com.gmail.at.sichyuriyy.javatraining.homework1.rsa.keygenerator.impl;

import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher.RsaPrivateKey;
import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher.RsaPublicKey;
import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher.impl.RsaPrivateKeyImpl;
import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher.impl.RsaPublicKeyImpl;
import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.keygenerator.KeyPair;
import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.keygenerator.RsaKeyGenerator;
import javafx.util.Pair;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by Yuriy on 02.02.2017.
 */
public class RsaKeyGeneratorImpl implements RsaKeyGenerator {

    private static final BigInteger publicExponent = new BigInteger("65537");
    private static final BigInteger one = BigInteger.ONE;
    private static final int modulesLength = 1024;

    private SecureRandom random = new SecureRandom();

    @Override
    public KeyPair generateKeys() {
        BigInteger p = BigInteger.probablePrime(modulesLength / 2, random);
        BigInteger q = BigInteger.probablePrime(modulesLength / 2, random);

        BigInteger phi = (p.subtract(one)).multiply(q.subtract(one));

        BigInteger modulus = p.multiply(q);
        BigInteger privateExponent = publicExponent.modInverse(phi);

        RsaPublicKey publicKey = new RsaPublicKeyImpl(modulus, publicExponent);
        RsaPrivateKey privateKey = new RsaPrivateKeyImpl(modulus, privateExponent);

        return new KeyPairImpl(publicKey, privateKey);
    }
}
