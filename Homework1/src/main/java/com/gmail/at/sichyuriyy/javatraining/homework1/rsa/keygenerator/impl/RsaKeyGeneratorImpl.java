package com.gmail.at.sichyuriyy.javatraining.homework1.rsa.keygenerator.impl;

import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher.RsaPrivateKey;
import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher.RsaPublicKey;
import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher.impl.RsaPrivateKeyImpl;
import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher.impl.RsaPublicKeyImpl;
import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.keygenerator.KeyPair;
import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.keygenerator.RsaKeyGenerator;

import static java.math.BigInteger.ZERO;
import static java.math.BigInteger.ONE;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by Yuriy on 02.02.2017.
 */
public class RsaKeyGeneratorImpl implements RsaKeyGenerator {

    private static final int MODULUS_MIN_BIT_LENGTH = 9;

    private static final int DEFAULT_MODULUS_LENGTH = 1024;

    private ArrayList<BigInteger> publicExponents;

    private SecureRandom random = new SecureRandom();

    public RsaKeyGeneratorImpl() {
        publicExponents = new ArrayList<>();
        publicExponents.add(BigInteger.valueOf(65537));
        publicExponents.add(BigInteger.valueOf(17));
        publicExponents.add(BigInteger.valueOf(3));
        publicExponents.sort(Comparator.reverseOrder());

    }

    @Override
    public KeyPair generateKeys() {
        return generateKeys(DEFAULT_MODULUS_LENGTH);
    }

    @Override
    public KeyPair generateKeys(BigInteger p, BigInteger q) {
        if (!p.isProbablePrime(5) || !q.isProbablePrime(5)) {
            throw new IllegalArgumentException("p and q must be prime numbers");
        }
        if (p.multiply(q).bitLength() < MODULUS_MIN_BIT_LENGTH) {
            throw new IllegalArgumentException("modulus(p*q) is to short");
        }
        return generateKeysUnchecked(p, q);
    }

    @Override
    public KeyPair generateKeys(int modulusBitLength) {
        if (modulusBitLength < MODULUS_MIN_BIT_LENGTH) {
            throw new IllegalArgumentException("modulus bitLength must be 9 or greater");
        }

        BigInteger p;
        BigInteger q;

        int tempPrimeBitLength = modulusBitLength / 2;

        do {
            p = generatePrime(tempPrimeBitLength);
            q = generatePrime(tempPrimeBitLength);
            tempPrimeBitLength++;

        } while (p.multiply(q).bitLength() < MODULUS_MIN_BIT_LENGTH);
        return generateKeysUnchecked(p, q);
    }

    @Override
    public BigInteger generatePrime(int bitLength) {
        BigInteger prime;

        do {
            prime = BigInteger.probablePrime(bitLength, random);
        } while(!prime.isProbablePrime(5));

        return prime;
    }

    private KeyPair generateKeysUnchecked(BigInteger p, BigInteger q) {


        BigInteger modulus = p.multiply(q);

        BigInteger phi = (p.subtract(ONE)).multiply(q.subtract(ONE));

        BigInteger publicExponent = choseExponent(phi);

        BigInteger privateExponent = publicExponent.modInverse(phi);

        RsaPublicKey publicKey = new RsaPublicKeyImpl(modulus, publicExponent);
        RsaPrivateKey privateKey = new RsaPrivateKeyImpl(modulus, privateExponent);

        return new KeyPairImpl(publicKey, privateKey);
    }

    private BigInteger choseExponent(BigInteger phi) {
        for (BigInteger tempExponent: publicExponents) {
            if (tempExponent.compareTo(phi) < 0
                    && !phi.mod(tempExponent).equals(ZERO)) {
                return tempExponent;
            }
        }
        return generatePublicExponent(phi);
    }

    private BigInteger generatePublicExponent(BigInteger phi) {
        BigInteger two = BigInteger.valueOf(2);
        BigInteger tempExponent = BigInteger.valueOf(5);

        while (tempExponent.compareTo(phi) < 0) {
            tempExponent = tempExponent.add(two);
            if (tempExponent.gcd(phi).equals(ONE))
                break;
        }
        return tempExponent;
    }




}
