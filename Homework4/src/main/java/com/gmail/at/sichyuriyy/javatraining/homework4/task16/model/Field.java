package com.gmail.at.sichyuriyy.javatraining.homework4.task16.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yuriy on 06.03.2017.
 */
public class Field {

    public static final int FIELD_SIZE = 10;

    private Cell [][]cells;
    private List<Ship> ships;

    public Field() {
        ships = new ArrayList<>();
        cells = new Cell[FIELD_SIZE][10];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public Cell getCell(int i, int j) {
        return cells[i][j];
    }

    public List<Ship> getShips() {
        return ships;
    }

    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }
}
