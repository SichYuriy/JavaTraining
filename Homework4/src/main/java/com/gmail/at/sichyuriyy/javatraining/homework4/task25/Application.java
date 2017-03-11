package com.gmail.at.sichyuriyy.javatraining.homework4.task25;

import com.gmail.at.sichyuriyy.javatraining.homework4.task25.controller.FieldController;
import com.gmail.at.sichyuriyy.javatraining.homework4.task25.controller.GameController;
import com.gmail.at.sichyuriyy.javatraining.homework4.task25.model.Caretaker;
import com.gmail.at.sichyuriyy.javatraining.homework4.task25.model.Cell;
import com.gmail.at.sichyuriyy.javatraining.homework4.task25.model.Field;
import com.gmail.at.sichyuriyy.javatraining.homework4.task25.model.GameOriginator;
import com.gmail.at.sichyuriyy.javatraining.homework4.task25.renderer.FieldRenderer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Yuriy on 3/11/2017.
 */
public class Application {

    private static final int FIELD_SIZE = 3;

    private GameController gameController = new GameController();
    private FieldController fieldController = new FieldController();
    private FieldRenderer fieldRenderer = new FieldRenderer();

    private GameOriginator gameOriginator;
    private Caretaker caretaker;

    private boolean isExit;
    private Scanner scanner = new Scanner(System.in);

    private Map<Cell, Character> symbolMap;

    public Application() {
        gameOriginator = new GameOriginator();
        caretaker = new Caretaker();
        symbolMap = new HashMap<>();
        symbolMap.put(Cell.NOUGHT, '0');
        symbolMap.put(Cell.CROSS, 'X');
    }

    public void start() {
        while (!isExit) {
            fieldRenderer.renderField(gameOriginator.getField());
            if (fieldController.isCrossCombinationPresent(gameOriginator.getField())) {
                System.out.println("Player (X) is winner!");
                isExit = true;
            } else if (fieldController.isNoughtCombinationPresent(gameOriginator.getField())) {
                System.out.println("Player (0) is winner!");
                isExit = true;
            } else {
                Cell turn = gameOriginator.getTurn();
                turn(turn);
            }
        }

    }

    public void turn(Cell cell) {
        System.out.println("player (" + symbolMap.get(cell) + ") turn.");
        int menu = scanner.nextInt();
        switch (menu) {
            case 1:
                int i = scanner.nextInt() - 1;
                int j = scanner.nextInt() - 1;
                if (!isValidIndexes(i, j))
                    break;
                if (cell.equals(Cell.CROSS)) {
                    gameController.tryPutCross(gameOriginator, i, j,
                            caretaker);
                } else {
                    gameController.tryPutNought(gameOriginator, i, j,
                            caretaker);
                }
                break;
            case 2:
                gameController.undo(gameOriginator, caretaker);
                break;
            case 0:
                isExit = true;
                break;
        }
    }

    private boolean isValidIndexes(int i, int j) {
        return i >= 0 && i < FIELD_SIZE
                && j >= 0 && j < FIELD_SIZE;
    }
}
