package com.gmail.at.sichyuriyy.javatraining.homework4.task16.controller;

import com.gmail.at.sichyuriyy.javatraining.homework4.task16.model.Cell;
import com.gmail.at.sichyuriyy.javatraining.homework4.task16.model.Ship;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 3/8/2017.
 */
public class ShipControllerTest {

    private ShipController shipController = new ShipController();

    @Test
    public void tryMoveLeftTrue() {
        Ship ship = new Ship(1);
        ship.setCells(Collections.singletonList(new Cell(0, 1)));

        assertTrue(shipController.tryMoveLeft(ship));
        assertTrue(equalCellCoordinates(0, 0, ship.getCells().get(0)));
    }

    @Test
    public void tryMoveLeftFalse() {
        Ship ship = new Ship(1);
        ship.setCells(Collections.singletonList(new Cell(0, 0)));

        assertFalse(shipController.tryMoveLeft(ship));
        assertTrue(equalCellCoordinates(0, 0, ship.getCells().get(0)));
    }

    @Test
    public void tryMoveUpTrue() {
        Ship ship = new Ship(1);
        ship.setCells(Collections.singletonList(new Cell(1, 0)));

        assertTrue(shipController.tryMoveUp(ship));
        assertTrue(equalCellCoordinates(0, 0, ship.getCells().get(0)));
    }

    @Test
    public void tryMoveUpFalse() {
        Ship ship = new Ship(1);
        ship.setCells(Collections.singletonList(new Cell(0, 0)));

        assertFalse(shipController.tryMoveUp(ship));
        assertTrue(equalCellCoordinates(0, 0, ship.getCells().get(0)));
    }

    @Test
    public void tryMoveRightTrue() {
        Ship ship = new Ship(1);
        ship.setCells(Collections.singletonList(new Cell(0, 0)));

        assertTrue(shipController.tryMoveRight(ship));
        assertTrue(equalCellCoordinates(0, 1, ship.getCells().get(0)));
    }

    @Test
    public void tryMoveRightFalse() {
        Ship ship = new Ship(1);
        ship.setCells(Collections.singletonList(new Cell(0, 9)));

        assertFalse(shipController.tryMoveRight(ship));
        assertTrue(equalCellCoordinates(0, 9, ship.getCells().get(0)));
    }

    @Test
    public void tryMoveDownTrue() {
        Ship ship = new Ship(1);
        ship.setCells(Collections.singletonList(new Cell(0, 0)));

        assertTrue(shipController.tryMoveDown(ship));
        assertTrue(equalCellCoordinates(1, 0, ship.getCells().get(0)));
    }

    @Test
    public void tryMoveDownFalse() {
        Ship ship = new Ship(1);
        ship.setCells(Collections.singletonList(new Cell(9, 0)));

        assertFalse(shipController.tryMoveDown(ship));
        assertTrue(equalCellCoordinates(9, 0, ship.getCells().get(0)));
    }

    @Test
    public void tryRotateHorizontalFalse() {
        Ship ship = new Ship(3);
        ship.setCells(Arrays.asList(new Cell(0, 8), new Cell(1, 8), new Cell(2, 8)));
        Ship expected = new Ship(3);
        expected.setCells(Arrays.asList(new Cell(0, 8), new Cell(1, 8), new Cell(2, 8)));
        assertFalse(shipController.tryRotate(ship));
        assertTrue(equalShipCoordinates(expected, ship));
    }

    @Test
    public void tryRotateHorizontalTrue() {
        Ship ship = new Ship(3);
        ship.setCells(Arrays.asList(new Cell(0, 7), new Cell(1, 7), new Cell(2, 7)));
        Ship expected = new Ship(3);
        expected.setCells(Arrays.asList(new Cell(0, 7), new Cell(0, 8), new Cell(0, 9)));
        assertTrue(shipController.tryRotate(ship));
        assertTrue(equalShipCoordinates(expected, ship));
    }

    @Test
    public void tryRotateVerticalFalse() {
        Ship ship = new Ship(3);
        ship.setCells(Arrays.asList(new Cell(8, 0), new Cell(8, 1), new Cell(8, 2)));
        Ship expected = new Ship(3);
        expected.setCells(Arrays.asList(new Cell(8, 0), new Cell(8, 1), new Cell(8, 2)));
        assertFalse(shipController.tryRotate(ship));
        assertTrue(equalShipCoordinates(expected, ship));

    }

    @Test
    public void tryRotateVerticalTrue() {
        Ship ship = new Ship(3);
        ship.setCells(Arrays.asList(new Cell(7, 0), new Cell(7, 1), new Cell(7, 2)));
        Ship expected = new Ship(3);
        expected.setCells(Arrays.asList(new Cell(7, 0), new Cell(8, 0), new Cell(9, 0)));
        assertTrue(shipController.tryRotate(ship));
        assertTrue(equalShipCoordinates(expected, ship));

    }

    private boolean equalCellCoordinates(int expectedI, int expectedJ, Cell cell) {
        return cell.getI() == expectedI && cell.getJ() == expectedJ;
    }

    private boolean equalShipCoordinates(Ship expected, Ship actual) {
        Iterator<Cell> expectedIt = expected.getCells().iterator();
        Iterator<Cell> actualIt = actual.getCells().iterator();
        while (expectedIt.hasNext()) {
            Cell expectedCell = expectedIt.next();
            Cell actualCell = actualIt.next();
            if (!equalCellCoordinates(expectedCell.getI(), expectedCell.getJ(), actualCell)) {
                return false;
            }
        }
        return !actualIt.hasNext();
    }

}