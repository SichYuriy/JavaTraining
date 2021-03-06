package com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher;

import java.math.BigInteger;

/**
 * Created by Yuriy on 02.02.2017.
 */
public interface RsaKey {


    /**
     * @return common part of public and private keys
     *      during rsa encrypting/decrypting
     */
    BigInteger getModulus();
}
