package com.gmail.at.sichyuriyy.javatraining.homework1.rsa.keygenerator;

import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher.RsaPrivateKey;
import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher.RsaPublicKey;

/**
 * Created by Yuriy on 02.02.2017.
 */
public interface KeyPair {

    RsaPublicKey getPublicKey();
    RsaPrivateKey getPrivateKey();
}
