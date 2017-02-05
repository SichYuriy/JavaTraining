package com.gmail.at.sichyuriyy.javatraining.homework1.rsa.keygenerator.impl;

import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.keygenerator.KeyPair;
import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.keygenerator.RsaKeyGenerator;
import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.util.MathUtils;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 05.02.2017.
 */
public class RsaKeyGeneratorImplTest {

    RsaKeyGenerator keyGenerator = new RsaKeyGeneratorImpl();

    @Test
    public void generateKeys_bigPrimes() {

        BigInteger p = new BigInteger("9905423035874484276226714083153108520124347895276841023760963582290696588874019807760102596992187823052274847424595066231324980108574272719420554555204271");
        BigInteger q = new BigInteger("11532843067979234999059822667599745331128401400465057989200389866313012740440503494769075535250476666833528973069318567060686040527898457837424595403272319");

        KeyPair keyPair = keyGenerator.generateKeys(p, q);

        BigInteger phi = q.subtract(BigInteger.ONE)
                .multiply(p.subtract(BigInteger.ONE));

        BigInteger actual = keyPair.getPublicKey().getPublicExponent()
                .multiply(keyPair.getPrivateKey().getPrivateExponent())
                .gcd(phi);
        BigInteger expected = BigInteger.ONE;
        assertEquals(expected, actual);
    }

    @Test
    public void generateKeys_notBigPrimes() {

        BigInteger p = new BigInteger("103");
        BigInteger q = new BigInteger("137");

        KeyPair keyPair = keyGenerator.generateKeys(p, q);

        BigInteger phi = q.subtract(BigInteger.ONE)
                .multiply(p.subtract(BigInteger.ONE));

        BigInteger actual = keyPair.getPublicKey().getPublicExponent()
                .multiply(keyPair.getPrivateKey().getPrivateExponent())
                .gcd(phi);
        BigInteger expected = BigInteger.ONE;
        assertEquals(expected, actual);
    }

    @Test
    public void generatePrime() {
        BigInteger prime = keyGenerator.generatePrime(20);
        assertTrue(MathUtils.isPrime(prime));
    }

    @Test(expected = ArithmeticException.class)
    public void generatePrime_badBitLength() {
        BigInteger prime = keyGenerator.generatePrime(0);
        assertTrue(MathUtils.isPrime(prime));
    }

    @Test(expected = IllegalArgumentException.class)
    public void generateKeys_notPrimes() {
        BigInteger badP = BigInteger.valueOf(77);
        BigInteger q = BigInteger.valueOf(17);
        keyGenerator.generateKeys(badP, q);
    }

    @Test(expected = IllegalArgumentException.class)
    public void generateKeys_tooShortPrimes() {
        BigInteger badP = BigInteger.valueOf(2);
        BigInteger q = BigInteger.valueOf(3);
        keyGenerator.generateKeys(badP, q);
    }

    @Test(expected = IllegalArgumentException.class)
    public void generateKeys_tooShortBitLength() {
        keyGenerator.generateKeys(5);
    }

    @Test
    public void generateKeys() {
        KeyPair keyPair = keyGenerator.generateKeys(35);
        int modulusBitLength = keyPair.getPrivateKey().getModulus().bitLength();

        boolean actual = modulusBitLength >= 33 &&modulusBitLength <= 37;
        assertTrue(actual);
    }


}