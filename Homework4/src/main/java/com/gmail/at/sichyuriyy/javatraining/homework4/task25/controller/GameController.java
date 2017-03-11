package com.gmail.at.sichyuriyy.javatraining.homework4.task25.controller;

import com.gmail.at.sichyuriyy.javatraining.homework4.task25.model.*;

/**
 * Created by Yuriy on 3/11/2017.
 */
public class GameController {

    public void undo(GameOriginator game, Caretaker caretaker) {
        Memento memento = caretaker.poll();
        if (memento != null) {
            game.setMemento(memento);
        }
    }

    public boolean tryPutCross(GameOriginator gameOriginator, int i, int j,
                               Caretaker caretaker) {
        if (!gameOriginator.getField().isEmpty(i, j)) {
            return false;
        }
        caretaker.push(gameOriginator.createMemento());
        gameOriginator.getField().putCross(i, j);
        gameOriginator.setTurn(Cell.NOUGHT);
        return true;
    }

    public boolean tryPutNought(GameOriginator gameOriginator, int i, int j,
                                Caretaker caretaker) {
        if (!gameOriginator.getField().getCell(i, j).equals(Cell.EMPTY)) {
            return false;
        }
        caretaker.push(gameOriginator.createMemento());
        gameOriginator.getField().putNought(i, j);
        gameOriginator.setTurn(Cell.CROSS);
        return true;
    }
}
