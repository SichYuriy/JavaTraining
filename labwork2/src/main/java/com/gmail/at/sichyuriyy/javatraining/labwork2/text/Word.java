package com.gmail.at.sichyuriyy.javatraining.labwork2.text;

/**
 * Created by Yuriy on 28.02.2017.
 */
public interface Word extends SentencePart {

    String getStringValue();

    int letterCount(Letter letter);
}