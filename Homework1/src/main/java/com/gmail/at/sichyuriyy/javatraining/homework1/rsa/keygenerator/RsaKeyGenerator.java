package com.gmail.at.sichyuriyy.javatraining.homework1.rsa.keygenerator;

import java.math.BigInteger;

/**
 * Created by Yuriy on 02.02.2017.
 */
public interface RsaKeyGenerator {

   /**
    * @return pair of public and private keys to encrypt and decrypt data using
    *       {@link com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher.RsaCipher RsaCipher}
    */
   KeyPair generateKeys();

   KeyPair generateKeys(BigInteger p, BigInteger q);

   KeyPair generateKeys(int modulusBitLength);

   BigInteger generatePrime(int bitLength);

}
