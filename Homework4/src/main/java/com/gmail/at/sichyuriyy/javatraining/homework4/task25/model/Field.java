package com.gmail.at.sichyuriyy.javatraining.homework4.task25.model;

import com.gmail.at.sichyuriyy.javatraining.homework4.task20.Figure;

import java.util.Arrays;

/**
 * Created by Yuriy on 3/11/2017.
 */
public class Field {

    private static final int FIELD_SIZE = 3;

    private Cell[][] cells;

    public Field() {
        cells = new Cell[FIELD_SIZE][FIELD_SIZE];
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                cells[i][j] = Cell.EMPTY;
            }
        }
    }

    public Cell getCell(int i, int j) {
        return cells[i][j];
    }

    public void setCell(Cell cell, int i, int j) {
        cells[i][j] = cell;
    }

    public void putNought(int i, int j) {
        cells[i][j] = Cell.NOUGHT;
    }

    public void putCross(int i, int j) {
        cells[i][j] = Cell.CROSS;
    }

    public boolean isEmpty(int i, int j) {
        return cells[i][j].equals(Cell.EMPTY);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Field field = (Field) o;

        return Arrays.deepEquals(cells, field.cells);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(cells);
    }
}
