package com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher;

import java.math.BigInteger;

/**
 * Created by Yuriy on 02.02.2017.
 */
public interface RsaPrivateKey extends RsaKey {

    BigInteger getPrivateExponent();
}