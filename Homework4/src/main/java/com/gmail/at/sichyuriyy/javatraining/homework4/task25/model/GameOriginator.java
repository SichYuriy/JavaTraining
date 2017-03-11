package com.gmail.at.sichyuriyy.javatraining.homework4.task25.model;

/**
 * Created by Yuriy on 3/11/2017.
 */
public class GameOriginator {

    private static final int FIELD_SIZE = 3;

    private Field field;
    private Cell turn;

    public GameOriginator() {
        this.field = new Field();
        this.turn = Cell.CROSS;
    }

    public Field getField() {
        return field;
    }

    public Cell getTurn() {
        return turn;
    }

    public void setTurn(Cell turn) {
        this.turn = turn;
    }

    public Memento createMemento() {
        Memento memento = new Memento();
        memento.setTurn(turn);
        Field mementoField = new Field();
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
             mementoField.setCell(field.getCell(i, j), i, j);
            }
        }
        memento.setField(mementoField);
        return memento;
    }

    public void setMemento(Memento memento) {
        this.field = memento.getField();
        this.turn = memento.getTurn();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GameOriginator that = (GameOriginator) o;

        if (field != null ? !field.equals(that.field) : that.field != null) return false;
        return turn == that.turn;
    }

    @Override
    public int hashCode() {
        int result = field != null ? field.hashCode() : 0;
        result = 31 * result + (turn != null ? turn.hashCode() : 0);
        return result;
    }
}
