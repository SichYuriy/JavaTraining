package com.gmail.at.sichyuriyy.javatraining.homework1.rsa.keygenerator;

import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher.RsaPrivateKey;
import com.gmail.at.sichyuriyy.javatraining.homework1.rsa.cipher.RsaPublicKey;
import javafx.util.Pair;

/**
 * Created by Yuriy on 02.02.2017.
 */
public interface RsaKeyGenerator {

   KeyPair generateKeys();

}
