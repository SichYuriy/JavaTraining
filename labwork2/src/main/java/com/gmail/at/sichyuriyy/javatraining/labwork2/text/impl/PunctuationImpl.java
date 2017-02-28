package com.gmail.at.sichyuriyy.javatraining.labwork2.text.impl;

import com.gmail.at.sichyuriyy.javatraining.labwork2.text.Punctuation;

/**
 * Created by Yuriy on 28.02.2017.
 */
public class PunctuationImpl extends AbstractSymbol implements Punctuation {

    public PunctuationImpl(char symbol) {
        super(symbol);
    }

    @Override
    public String getStringValue() {
        return String.valueOf(getCharValue());
    }
}
