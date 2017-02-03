package com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher;

import java.math.BigInteger;

/**
 * Created by Yuriy on 02.02.2017.
 */
public interface RsaPublicKey extends RsaKey {


    /**
     * @return public exponent of RsaPrivateKey for decryption using
     *      {@link com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher.RsaCipher RsaCipher}
     */
    BigInteger getPublicExponent();
}
