package com.gmail.at.sichyuriyy.javatraining.homework4.task16.controller;

import com.gmail.at.sichyuriyy.javatraining.homework4.task16.model.Cell;
import com.gmail.at.sichyuriyy.javatraining.homework4.task16.model.Field;
import com.gmail.at.sichyuriyy.javatraining.homework4.task16.model.Ship;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yuriy on 06.03.2017.
 */
public class FieldController {

    public static final int FIELD_SIZE = 10;

    public boolean tryAddShip(Field field, Ship ship) {
        for (Ship existingShip: field.getShips()) {
            if (isOverlaps(existingShip, ship)) {
                return false;
            }
        }
        List<Cell> fieldCells = new ArrayList<>();
        for (Cell cell: ship.getCells()) {
            fieldCells.add(field.getCell(cell.getI(), cell.getJ()));
        }
        ship.setCells(fieldCells);
        field.getShips().add(ship);
        return true;
    }

    public boolean makeShoot(Field field, int i, int j) {
        boolean result = false;
        for (Ship ship: field.getShips()) {
            for (Cell cell: ship.getCells()) {
                if (cell.getI() == i && cell.getJ() == j
                        && !cell.isBombed()) {
                    result = true;
                }

            }
        }
        field.getCell(i, j).setBombed(true);
        return result;
    }

    public void clear(Field field) {
        field.getShips().clear();
    }

    private boolean isOverlaps(Ship shipOne, Ship shipTwo) {
        int [][]field = new int[FIELD_SIZE][FIELD_SIZE];
        for (Cell cell: shipOne.getCells()) {
            field[cell.getI()][cell.getJ()]++;
        }
        for (Cell cell: shipTwo.getCells()) {
            if (field[cell.getI()][cell.getJ()] == 1
                    || (cell.getI() - 1 >= 0 && cell.getJ() - 1 >= 0 && field[cell.getI() - 1][cell.getJ() - 1] == 1)
                    || (cell.getJ() - 1 >= 0 && field[cell.getI()][cell.getJ() - 1] == 1)
                    || (cell.getI() - 1 >= 0 && field[cell.getI() - 1][cell.getJ()] == 1)
                    || (cell.getI() + 1 < FIELD_SIZE && field[cell.getI() + 1][cell.getJ()] == 1)
                    || (cell.getJ() + 1 < FIELD_SIZE && field[cell.getI()][cell.getJ() + 1] == 1)
                    || (cell.getI() + 1 < FIELD_SIZE && cell.getJ() + 1 < FIELD_SIZE && field[cell.getI() + 1][cell.getJ() + 1] == 1)
                    || (cell.getJ() + 1 < FIELD_SIZE && cell.getI() - 1 >= 0 && field[cell.getI() - 1][cell.getJ() + 1] == 1)
                    || (cell.getJ() - 1 >= 0 && cell.getI() + 1 < FIELD_SIZE && field[cell.getI() + 1][cell.getJ() - 1] == 1)) {
                return true;
            }
        }
        return false;
    }
}
