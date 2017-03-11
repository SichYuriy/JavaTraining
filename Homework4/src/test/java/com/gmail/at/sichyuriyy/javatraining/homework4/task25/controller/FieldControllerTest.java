package com.gmail.at.sichyuriyy.javatraining.homework4.task25.controller;

import com.gmail.at.sichyuriyy.javatraining.homework4.task25.model.Field;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 3/11/2017.
 */
public class FieldControllerTest {

    FieldController fieldController = new FieldController();
    Field field;

    @Before
    public void setUp() throws Exception {
        field = new Field();

    }

    @Test
    public void isNoughtCombinationPresentRow() {
        field.putNought(1, 0);
        field.putNought(1, 1);
        field.putNought(1, 2);
        assertTrue(fieldController.isNoughtCombinationPresent(field));
    }

    @Test
    public void isNoughtCombinationPresentColumn() {
        field.putNought(0, 1);
        field.putNought(1, 1);
        field.putNought(2, 1);
        assertTrue(fieldController.isNoughtCombinationPresent(field));
    }

    @Test
    public void isNoughtCombinationPresentDiagonalOne() {
        field.putNought(0, 0);
        field.putNought(1, 1);
        field.putNought(2, 2);
        assertTrue(fieldController.isNoughtCombinationPresent(field));
    }

    @Test
    public void isNoughtCombinationPresentDiagonalTwo() {
        field.putNought(0, 2);
        field.putNought(1, 1);
        field.putNought(2, 0);
        assertTrue(fieldController.isNoughtCombinationPresent(field));
    }

    @Test
    public void isNoughtCombinationPresentNone() {
        assertFalse(fieldController.isNoughtCombinationPresent(field));
    }

    @Test
    public void isCrossCombinationPresentNone() {
        assertFalse(fieldController.isCrossCombinationPresent(field));
    }

}