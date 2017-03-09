package com.gmail.at.sichyuriyy.javatraining.homework4.task16.controller;

import com.gmail.at.sichyuriyy.javatraining.homework4.task16.model.Cell;
import com.gmail.at.sichyuriyy.javatraining.homework4.task16.model.Ship;

import java.util.List;

/**
 * Created by Yuriy on 06.03.2017.
 */
public class ShipController {

    private static final int FIELD_SIZE = 10;

    public boolean tryMoveLeft(Ship ship) {
        if (!canMoveLeft(ship))
            return false;

        for (Cell cell: ship.getCells()) {
            cell.setJ(cell.getJ() - 1);
        }
        return true;
    }

    public boolean tryMoveUp(Ship ship) {
        if (!canMoveUp(ship))
            return false;
        for (Cell cell: ship.getCells()) {
            cell.setI(cell.getI() - 1);
        }
        return true;
    }

    public boolean tryMoveRight(Ship ship) {
        if (!canMoveRight(ship))
            return false;
        for (Cell cell: ship.getCells()) {
            cell.setJ(cell.getJ() + 1);
        }
        return true;
    }

    public boolean tryMoveDown(Ship ship) {
        if (!canMoveDown(ship))
            return false;
        for (Cell cell: ship.getCells()) {
            cell.setI(cell.getI() + 1);
        }
        return true;
    }

    public boolean tryRotate(Ship ship) {
        List<Cell> cells = ship.getCells();
        if (cells.size() == 1)
            return true;
        if (cells.get(0).getI() == cells.get(1).getI()) {
            return trySetVertical(ship);
        } else {
            return trySetHorizontal(ship);
        }

    }

    private boolean canMoveLeft(Ship ship) {
        for (Cell cell: ship.getCells()) {
            if (cell.getJ() - 1 < 0) {
                return false;
            }
        }
        return true;
    }

    private boolean canMoveUp(Ship ship) {
        for (Cell cell: ship.getCells()) {
            if (cell.getI() - 1 < 0) {
                return false;
            }
        }
        return true;
    }

    private boolean canMoveRight(Ship ship) {
        for (Cell cell: ship.getCells()) {
            if (cell.getJ() + 1 >= FIELD_SIZE) {
                return false;
            }
        }
        return true;
    }

    private boolean canMoveDown(Ship ship) {
        for (Cell cell: ship.getCells()) {
            if (cell.getI() + 1 >= FIELD_SIZE) {
                return false;
            }
        }
        return true;
    }

    private boolean trySetVertical(Ship ship) {
        List<Cell> cells = ship.getCells();
        if (cells.get(0).getI() + cells.size() > FIELD_SIZE) {
            return false;
        }
        int positionY = cells.get(0).getJ();
        int positionX = cells.get(0).getI();
        for (Cell cell: cells) {
            cell.setI(positionX);
            cell.setJ(positionY);
            positionX++;
        }
        return true;
    }

    private boolean trySetHorizontal(Ship ship) {
        List<Cell> cells = ship.getCells();
        if (cells.get(0).getJ() + cells.size() > FIELD_SIZE) {
            return false;
        }
        int positionX = cells.get(0).getI();
        int positionY = cells.get(0).getJ();
        for (Cell cell: cells) {
            cell.setI(positionX);
            cell.setJ(positionY);
            positionY++;
        }
        return true;
    }


}
