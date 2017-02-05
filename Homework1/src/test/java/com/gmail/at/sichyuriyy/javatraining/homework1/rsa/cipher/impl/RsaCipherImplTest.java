package com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher.impl;

import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher.RsaCipher;
import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.keygenerator.KeyPair;
import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.keygenerator.RsaKeyGenerator;
import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.keygenerator.impl.RsaKeyGeneratorImpl;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 02.02.2017.
 */
public class RsaCipherImplTest {

    private RsaCipher cipher = new RsaCipherImpl();
    private RsaKeyGenerator keyGenerator = new RsaKeyGeneratorImpl();



    @Test
    public void encryptDecrypt() {
        String message = "Hello world!";
        KeyPair keyPair = keyGenerator.generateKeys();
        byte[] encryptedData = cipher.encrypt(message.getBytes(), keyPair.getPublicKey());
        byte[] actualDecryptedData = cipher.decrypt(encryptedData, keyPair.getPrivateKey());
        byte[] expected = message.getBytes();

        assertArrayEquals(expected, actualDecryptedData);
    }

    @Test
    public void encrypt_largeData() {
        byte[] message = new byte[10000000];
        message[0] = 1;
        message[9999999] = 1;
        KeyPair keyPair = keyGenerator.generateKeys();
        byte[] encryptedData = cipher.encrypt(message, keyPair.getPublicKey());
        byte[] actualDecryptedData = cipher.decrypt(encryptedData, keyPair.getPrivateKey());

        byte[] expected = message;

        assertArrayEquals(expected, actualDecryptedData);
    }

    @Test
    public void encrypt_nullData() {
        KeyPair keyPair = keyGenerator.generateKeys();
        byte[] encryptedData = cipher.encrypt(null, keyPair.getPublicKey());
        byte[] expected = new byte[0];
        assertArrayEquals(expected, encryptedData);
    }

    @Test(expected = IllegalArgumentException.class)
    public void encrypt_keyNull() {
        cipher.encrypt("Hello!".getBytes(), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void encrypt_badKey() {
        BigInteger publicExponent = BigInteger.valueOf(2);
        BigInteger modulus = BigInteger.valueOf(6);

        RsaPublicKeyImpl key = new RsaPublicKeyImpl(modulus, publicExponent);
        cipher.encrypt("message".getBytes(), key);
    }

    @Test
    public void decrypt_nullData() {
        KeyPair keyPair = keyGenerator.generateKeys();
        byte[] decryptedData = cipher.decrypt(null, keyPair.getPrivateKey());
        byte[] expected = new byte[0];
        assertArrayEquals(expected, decryptedData);
    }

    @Test(expected = IllegalArgumentException.class)
    public void decrypt_keyNull() {
        cipher.decrypt("Hello!".getBytes(), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void decrypt_badKey() {
        BigInteger privateExponent = BigInteger.valueOf(2);
        BigInteger modulus = BigInteger.valueOf(6);

        RsaPrivateKeyImpl key = new RsaPrivateKeyImpl(modulus, privateExponent);
        cipher.decrypt("message".getBytes(), key);
    }

}