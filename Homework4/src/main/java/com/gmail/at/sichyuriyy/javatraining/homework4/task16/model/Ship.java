package com.gmail.at.sichyuriyy.javatraining.homework4.task16.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yuriy on 06.03.2017.
 */
public class Ship {

    private List<Cell> cells;

    public Ship(int size) {
        cells = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            cells.add(new Cell(0, i));
        }
    }

    public boolean isDead() {
        return cells.stream()
                .allMatch(Cell::isBombed);
    }

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }
}
