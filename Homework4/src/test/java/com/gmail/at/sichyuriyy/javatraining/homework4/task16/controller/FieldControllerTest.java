package com.gmail.at.sichyuriyy.javatraining.homework4.task16.controller;

import com.gmail.at.sichyuriyy.javatraining.homework4.task16.model.Cell;
import com.gmail.at.sichyuriyy.javatraining.homework4.task16.model.Field;
import com.gmail.at.sichyuriyy.javatraining.homework4.task16.model.Ship;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 3/8/2017.
 */
public class FieldControllerTest {

    private FieldController fieldController = new FieldController();

    @Test
    public void tryAddShipCorrect() {
        Field field = new Field();
        Ship existingShip = new Ship(1);
        existingShip.setCells(Collections.singletonList(field.getCell(9, 9)));
        field.getShips().add(existingShip);

        Ship shipToAdd = new Ship(2);
        boolean result = fieldController.tryAddShip(field, shipToAdd);
        assertTrue(result);

        List<Cell> expected = Arrays.asList(field.getCell(0, 0), field.getCell(0, 1));
        List<Cell> actual = field.getShips().get(1).getCells();

        assertEquals(expected, actual);
    }

    @Test
    public void tryAddShipOverlapTopLeft() {
        Field field = new Field();
        Ship ship = new Ship(1);
        ship.setCells(Collections.singletonList(field.getCell(1, 1)));
        field.getShips().add(ship);

        Ship shipToAdd = new Ship(1);
        assertFalse(fieldController.tryAddShip(field, shipToAdd));
    }

    @Test
    public void tryAddShipOverlapTopMid() {
        Field field = new Field();
        Ship ship = new Ship(1);
        ship.setCells(Collections.singletonList(field.getCell(1, 1)));
        field.getShips().add(ship);

        Ship shipToAdd = new Ship(1);
        shipToAdd.setCells(Collections.singletonList(new Cell(0, 1)));
        assertFalse(fieldController.tryAddShip(field, shipToAdd));
    }

    @Test
    public void tryAddShipOverlapTopRight() {
        Field field = new Field();
        Ship ship = new Ship(1);
        ship.setCells(Collections.singletonList(field.getCell(1, 1)));
        field.getShips().add(ship);

        Ship shipToAdd = new Ship(1);
        shipToAdd.setCells(Collections.singletonList(new Cell(0, 2)));
        assertFalse(fieldController.tryAddShip(field, shipToAdd));
    }

    @Test
    public void tryAddShipOverlapMidRight() {
        Field field = new Field();
        Ship ship = new Ship(1);
        ship.setCells(Collections.singletonList(field.getCell(1, 1)));
        field.getShips().add(ship);

        Ship shipToAdd = new Ship(1);
        shipToAdd.setCells(Collections.singletonList(new Cell(1, 2)));
        assertFalse(fieldController.tryAddShip(field, shipToAdd));
    }

    @Test
    public void tryAddShipOverlapBottomRight() {
        Field field = new Field();
        Ship ship = new Ship(1);
        ship.setCells(Collections.singletonList(field.getCell(1, 1)));
        field.getShips().add(ship);

        Ship shipToAdd = new Ship(1);
        shipToAdd.setCells(Collections.singletonList(new Cell(2, 2)));
        assertFalse(fieldController.tryAddShip(field, shipToAdd));
    }

    @Test
    public void tryAddShipOverlapBottomMid() {
        Field field = new Field();
        Ship ship = new Ship(1);
        ship.setCells(Collections.singletonList(field.getCell(1, 1)));
        field.getShips().add(ship);

        Ship shipToAdd = new Ship(1);
        shipToAdd.setCells(Collections.singletonList(new Cell(2, 1)));
        assertFalse(fieldController.tryAddShip(field, shipToAdd));
    }

    @Test
    public void tryAddShipOverlapBottomLeft() {
        Field field = new Field();
        Ship ship = new Ship(1);
        ship.setCells(Collections.singletonList(field.getCell(1, 1)));
        field.getShips().add(ship);

        Ship shipToAdd = new Ship(1);
        shipToAdd.setCells(Collections.singletonList(new Cell(2, 0)));
        assertFalse(fieldController.tryAddShip(field, shipToAdd));
    }

    @Test
    public void tryAddShipOverlapMidLeft() {
        Field field = new Field();
        Ship ship = new Ship(1);
        ship.setCells(Collections.singletonList(field.getCell(1, 1)));
        field.getShips().add(ship);

        Ship shipToAdd = new Ship(1);
        shipToAdd.setCells(Collections.singletonList(new Cell(1, 0)));
        assertFalse(fieldController.tryAddShip(field, shipToAdd));
    }

    @Test
    public void tryAddShipOverlapMidMid() {
        Field field = new Field();
        Ship ship = new Ship(1);
        ship.setCells(Collections.singletonList(field.getCell(1, 1)));
        field.getShips().add(ship);

        Ship shipToAdd = new Ship(1);
        shipToAdd.setCells(Collections.singletonList(new Cell(1, 1)));
        assertFalse(fieldController.tryAddShip(field, shipToAdd));
    }

    @Test
    public void makeShootEmptyShoot() {
        Field field = new Field();
        boolean result = fieldController.makeShoot(field, 1,1);
        assertFalse(result);
        assertTrue(field.getCell(1, 1).isBombed());
    }

    @Test
    public void makeShootNonBombedShip() {
        Field field = new Field();
        Ship ship = new Ship(1);
        ship.setCells(Collections.singletonList(field.getCell(0, 0)));
        field.getShips().add(ship);

        boolean result = fieldController.makeShoot(field, 0, 0);
        assertTrue(result);
        assertTrue(field.getCell(0, 0).isBombed());
    }

    @Test
    public void makeShootBombedShip() {
        Field field = new Field();
        Ship ship = new Ship(1);
        ship.setCells(Collections.singletonList(field.getCell(0, 0)));
        field.getShips().add(ship);
        field.getCell(0, 0).setBombed(true);

        boolean result = fieldController.makeShoot(field, 0, 0);
        assertFalse(result);
    }

    @Test
    public void clear() {
        Field field = new Field();
        field.getShips().add(new Ship(1));
        field.getShips().add(new Ship(3));

        fieldController.clear(field);

        assertTrue(field.getShips().isEmpty());
    }

}