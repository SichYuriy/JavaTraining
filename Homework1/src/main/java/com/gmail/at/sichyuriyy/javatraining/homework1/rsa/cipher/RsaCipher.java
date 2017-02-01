package com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher;

/**
 * Created by Yuriy on 02.02.2017.
 */
public interface RsaCipher {

    byte[] encrypt(byte []data, RsaPublicKey key);
    byte[] decrypt(byte []data, RsaPrivateKey key);



}
