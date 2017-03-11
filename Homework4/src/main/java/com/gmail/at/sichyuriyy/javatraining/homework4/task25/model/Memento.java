package com.gmail.at.sichyuriyy.javatraining.homework4.task25.model;

/**
 * Created by Yuriy on 3/11/2017.
 */
public class Memento {
    private Field field;
    private Cell turn;

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public Cell getTurn() {
        return turn;
    }

    public void setTurn(Cell turn) {
        this.turn = turn;
    }
}
