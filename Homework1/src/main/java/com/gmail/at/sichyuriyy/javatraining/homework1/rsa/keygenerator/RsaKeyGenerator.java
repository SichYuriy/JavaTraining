package com.gmail.at.sichyuriyy.javatraining.homework1.rsa.keygenerator;

/**
 * Created by Yuriy on 02.02.2017.
 */
@FunctionalInterface
public interface RsaKeyGenerator {

   /**
    * @return pair of public and private keys to encrypt and decrypt data using
    *       {@link com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher.RsaCipher RsaCipher}
    */
   KeyPair generateKeys();

}
