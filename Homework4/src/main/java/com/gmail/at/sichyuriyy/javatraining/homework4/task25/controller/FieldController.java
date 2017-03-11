package com.gmail.at.sichyuriyy.javatraining.homework4.task25.controller;

import com.gmail.at.sichyuriyy.javatraining.homework4.task20.Figure;
import com.gmail.at.sichyuriyy.javatraining.homework4.task25.model.Cell;
import com.gmail.at.sichyuriyy.javatraining.homework4.task25.model.Field;

import java.util.Arrays;

/**
 * Created by Yuriy on 3/11/2017.
 */
public class FieldController {

    private static final int FIELD_SIZE = 3;

    public boolean isNoughtCombinationPresent(Field field) {
        return checkRows(field, Cell.NOUGHT)
                || checkColumns(field, Cell.NOUGHT)
                || checkDiagonals(field, Cell.NOUGHT);
    }

    public boolean isCrossCombinationPresent(Field field) {
        return checkRows(field, Cell.CROSS)
                || checkColumns(field, Cell.CROSS)
                || checkDiagonals(field, Cell.CROSS);
    }

    private boolean checkRows(Field field, Cell cell) {
        for (int i = 0; i < FIELD_SIZE; i++) {
            if (isCompleteRow(field, i, cell))
                return true;
        }
        return false;
    }

    private boolean checkColumns(Field field, Cell cell) {
        for (int i = 0; i < FIELD_SIZE; i++) {
            if (isCompleteColumn(field, i, cell))
                return true;
        }
        return false;
    }

    private boolean isCompleteColumn(Field field, int columnIndex, Cell cell) {
        for (int i = 0; i < FIELD_SIZE; i++) {
            if (!field.getCell(i, columnIndex).equals(cell)) {
                return false;
            }
        }
        return true;
    }

    private boolean isCompleteRow(Field field, int rowIndex, Cell cell) {
        for (int j = 0; j < FIELD_SIZE; j++) {
            if (!field.getCell(rowIndex, j).equals(cell)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonals(Field field, Cell cell) {
        boolean result = true;
        for (int i = 0; i < FIELD_SIZE; i++) {
            if (!field.getCell(i, i).equals(cell)) {
                result = false;
                break;
            }
        }
        if (result) {
            return true;
        }
        for (int i = 0; i < FIELD_SIZE; i++) {
            if (!field.getCell(FIELD_SIZE - i - 1, i).equals(cell))
                return false;
        }
        return true;
    }
}
