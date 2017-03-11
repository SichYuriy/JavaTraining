package com.gmail.at.sichyuriyy.javatraining.homework4.task25.controller;

import com.gmail.at.sichyuriyy.javatraining.homework4.task25.model.Caretaker;
import com.gmail.at.sichyuriyy.javatraining.homework4.task25.model.Field;
import com.gmail.at.sichyuriyy.javatraining.homework4.task25.model.GameOriginator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 3/11/2017.
 */
public class GameControllerTest {

    private GameController gameController = new GameController();
    private GameOriginator gameOriginator;
    private Caretaker caretaker;

    @Before
    public void setUp() {
        gameOriginator = new GameOriginator();
        caretaker = new Caretaker();
    }

    @Test
    public void undoEmptyCaretaker() {
        Field expectedField = new Field();
        gameController.undo(gameOriginator, caretaker);

        assertEquals(expectedField, gameOriginator.getField());
    }

    @Test
    public void undo() {
        Field expectedField = new Field();
        gameController.tryPutCross(gameOriginator, 0, 0, caretaker);
        gameController.undo(gameOriginator, caretaker);

        assertEquals(expectedField, gameOriginator.getField());
    }

    @Test
    public void tryPutCrossTrue() {
        Field expectedField = new Field();
        expectedField.putCross(0, 0);
        
        assertTrue(gameController.tryPutCross(gameOriginator, 0, 0, caretaker));
        assertEquals(expectedField, gameOriginator.getField());
    }

    @Test
    public void tryPutCrossFalse() {
        gameController.tryPutCross(gameOriginator, 0, 0, caretaker);
        assertFalse(gameController.tryPutCross(gameOriginator, 0, 0, caretaker));
    }

    @Test
    public void tryPutNoughtTrue() {
        Field expectedField = new Field();
        expectedField.putNought(0, 0);

        assertTrue(gameController.tryPutNought(gameOriginator, 0, 0, caretaker));
        assertEquals(expectedField, gameOriginator.getField());
    }

    @Test
    public void tryPutNoughtFalse() {
        gameController.tryPutNought(gameOriginator, 0, 0, caretaker);
        assertFalse(gameController.tryPutNought(gameOriginator, 0, 0, caretaker));
    }

}