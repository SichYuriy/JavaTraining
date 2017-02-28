package com.gmail.at.sichyuriyy.javatraining.labwork2.text.impl;

import com.gmail.at.sichyuriyy.javatraining.labwork2.text.Symbol;

/**
 * Created by Yuriy on 28.02.2017.
 */
public class AbstractSymbol implements Symbol {

    char symbol;

    public AbstractSymbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public char getCharValue() {
        return symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractSymbol)) return false;

        AbstractSymbol that = (AbstractSymbol) o;

        return symbol == that.symbol;
    }

    @Override
    public int hashCode() {
        return (int) symbol;
    }
}
