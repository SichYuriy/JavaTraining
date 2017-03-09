package com.gmail.at.sichyuriyy.javatraining.homework4.task16.renderer;

import com.gmail.at.sichyuriyy.javatraining.homework4.task16.model.Cell;
import com.gmail.at.sichyuriyy.javatraining.homework4.task16.model.Field;
import com.gmail.at.sichyuriyy.javatraining.homework4.task16.model.Ship;

/**
 * Created by Yuriy on 06.03.2017.
 */
public class FieldRenderer {

    private static final int FIELD_SIZE = 10;

    private static final char AXIS_X_START_CHAR = 'a';
    private static final int AXIS_Y_START_NUMBER = 1;

    private static final char EMPTY_NON_BOMBED_CELL = '~';
    private static final char EMPTY_BOMBED_CELL = 'o';
    private static final char SHIP_BOMBED = 'X';
    private static final char SHIP_NON_BOMBED = '1';

    private static final char OVERLAP_SYMBOL = 'X';
    private static final char NEW_SHIP = '2';

    public void renderOwnField(Field field) {
        char [][]fieldSymbols = getFiledSymbols(field, true);
        renderField(fieldSymbols);
    }

    public void renderEnemyField(Field field) {
        char [][]fieldSymbols = getFiledSymbols(field, false);
        renderField(fieldSymbols);
    }

    public void renderFieldWithNewShip(Field field, Ship ship) {
        char [][]fieldSymbols = getFiledSymbols(field, true);
        for (Cell cell: ship.getCells()) {
            if (fieldSymbols[cell.getI()][cell.getJ()] == SHIP_NON_BOMBED) {
                fieldSymbols[cell.getI()][cell.getJ()] = OVERLAP_SYMBOL;
            } else {
                fieldSymbols[cell.getI()][cell.getJ()] = NEW_SHIP;
            }
        }
        renderField(fieldSymbols);
    }

    private void renderField(char[][] fieldSymbols) {
        System.out.print("   ");
        for (int i = 0; i < FIELD_SIZE; i++) {
            System.out.print((char)(AXIS_X_START_CHAR + i) + " ");
        }

        System.out.println();
        for (int i = 0; i < FIELD_SIZE; i++) {
            System.out.print(AXIS_Y_START_NUMBER + i + " ");
            if (i < 9) {
                System.out.print(" ");
            }
            for (int j = 0; j < FIELD_SIZE; j++) {
                System.out.print(fieldSymbols[i][j] + " ");
            }
            System.out.println();
        }
    }

    private char[][] getFiledSymbols(Field field, boolean renderNonBombedShips) {
        char[][] fieldSymbols = new char[FIELD_SIZE][FIELD_SIZE];
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (field.getCell(i, j).isBombed()) {
                    fieldSymbols[i][j] = EMPTY_BOMBED_CELL;
                } else {
                    fieldSymbols[i][j] = EMPTY_NON_BOMBED_CELL;
                }
            }
        }

        for (Ship ship: field.getShips()) {
            for (Cell cell: ship.getCells()) {
                if (cell.isBombed()) {
                    fieldSymbols[cell.getI()][cell.getJ()] = SHIP_BOMBED;
                } else if (renderNonBombedShips) {
                    fieldSymbols[cell.getI()][cell.getJ()] = SHIP_NON_BOMBED;
                }
            }
        }
        return fieldSymbols;
    }
}
