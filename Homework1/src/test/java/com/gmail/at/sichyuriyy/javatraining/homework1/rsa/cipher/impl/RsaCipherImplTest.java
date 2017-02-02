package com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher.impl;

import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher.RsaCipher;
import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher.RsaPrivateKey;
import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher.RsaPublicKey;
import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.keygenerator.KeyPair;
import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.keygenerator.RsaKeyGenerator;
import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.keygenerator.impl.RsaKeyGeneratorImpl;
import org.junit.Test;

import java.security.PublicKey;

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

    @Test
    public void encryptDecrypt_wrongKey() {
        String message = "Hello world!";
        KeyPair keyPair = keyGenerator.generateKeys();
        KeyPair wrongKeyPair = keyGenerator.generateKeys();

        RsaPublicKey publicKey = keyPair.getPublicKey();
        RsaPrivateKey wrongPrivateKey = wrongKeyPair.getPrivateKey();

        byte[] encryptedData = cipher.encrypt(message.getBytes(), publicKey);
        byte[] actualDecryptedData = cipher.decrypt(encryptedData, wrongPrivateKey);
        byte[] unexpected = message.getBytes();

        assertNotSame(unexpected, actualDecryptedData);

    }

}