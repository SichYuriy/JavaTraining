package com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher.impl;

import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher.RsaCipher;
import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher.RsaPrivateKey;
import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher.RsaPublicKey;
import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.exception.GreaterThenModulusException;
import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.keygenerator.KeyPair;
import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.keygenerator.RsaKeyGenerator;
import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.keygenerator.impl.RsaKeyGeneratorImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 02.02.2017.
 */
public class RsaCipherImplTest {

    RsaCipher cipher = new RsaCipherImpl();
    RsaKeyGenerator keyGenerator = new RsaKeyGeneratorImpl();



    @Test
    public void encryptDecrypt() {
        String message = "Hello world!";
        KeyPair keyPair = keyGenerator.generateKeys();
        byte[] encryptedData = cipher.encrypt(message.getBytes(), keyPair.getPublicKey());
        byte[] actualDecryptedData = cipher.decrypt(encryptedData, keyPair.getPrivateKey());
        byte[] expected = message.getBytes();

        assertArrayEquals(expected, actualDecryptedData);
    }

    @Test(expected = GreaterThenModulusException.class)
    public void encrypt_greaterThenModulusException() {
        byte[] message = new byte[10000000];
        message[0] = 1;
        message[9999999] = 1;
        KeyPair keyPair = keyGenerator.generateKeys();
        cipher.encrypt(message, keyPair.getPublicKey());

    }

    @Test(expected = GreaterThenModulusException.class)
    public void decrypt_greaterThenModulusException() {
        byte[] message = new byte[10000000];
        message[0] = 1;
        message[9999999] = 1;
        KeyPair keyPair = keyGenerator.generateKeys();
        cipher.decrypt(message, keyPair.getPrivateKey());

    }

    @Test(expected = NullPointerException.class)
    public void encrypt_dataNull() {
        KeyPair keyPair = keyGenerator.generateKeys();
        cipher.encrypt(null, keyPair.getPublicKey());
    }

    @Test(expected = NullPointerException.class)
    public void encrypt_keyNull() {
        cipher.encrypt("message".getBytes(), null);
    }

    @Test(expected = NullPointerException.class)
    public void decrypt_dataNull() {
        KeyPair keyPair = keyGenerator.generateKeys();
        cipher.decrypt(null, keyPair.getPrivateKey());
    }

    @Test(expected = NullPointerException.class)
    public void decrypt_keyNull() {
        cipher.decrypt("message".getBytes(), null);
    }

}