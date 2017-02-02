package com.gmail.at.sichyuriyy.javatraining.homework1.rsa.keygenerator.impl;

import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher.RsaPrivateKey;
import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher.RsaPublicKey;
import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher.impl.RsaPrivateKeyImpl;
import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher.impl.RsaPublicKeyImpl;
import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.keygenerator.KeyPair;
import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.keygenerator.RsaKeyGenerator;
import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by Yuriy on 02.02.2017.
 */
public class RsaKeyGeneratorImpl implements RsaKeyGenerator {

    private static final BigInteger publicExponent = new BigInteger("65537");
    private static final BigInteger ONE = BigInteger.ONE;
    private static final int MODULUS_LENGTH = 1024;

    private SecureRandom random = new SecureRandom();

    @Override
    public KeyPair generateKeys() {
        BigInteger p = BigInteger.probablePrime(MODULUS_LENGTH / 2, random);
        BigInteger q = BigInteger.probablePrime(MODULUS_LENGTH / 2, random);

        BigInteger phi = (p.subtract(ONE)).multiply(q.subtract(ONE));

        BigInteger modulus = p.multiply(q);
        BigInteger privateExponent = publicExponent.modInverse(phi);

        RsaPublicKey publicKey = new RsaPublicKeyImpl(modulus, publicExponent);
        RsaPrivateKey privateKey = new RsaPrivateKeyImpl(modulus, privateExponent);

        return new KeyPairImpl(publicKey, privateKey);
    }
}
