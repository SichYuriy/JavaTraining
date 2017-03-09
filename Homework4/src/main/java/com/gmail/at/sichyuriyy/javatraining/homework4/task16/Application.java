package com.gmail.at.sichyuriyy.javatraining.homework4.task16;

import com.gmail.at.sichyuriyy.javatraining.homework4.task16.controller.FieldController;
import com.gmail.at.sichyuriyy.javatraining.homework4.task16.controller.ShipController;
import com.gmail.at.sichyuriyy.javatraining.homework4.task16.model.*;
import com.gmail.at.sichyuriyy.javatraining.homework4.task16.renderer.FieldRenderer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Yuriy on 07.03.2017.
 */
public class Application {

    private static final int SHIP_ONE_COUNT = 4;
    private static final int SHIP_TWO_COUNT = 3;
    private static final int SHIP_THREE_COUNT = 2;
    private static final int SHIP_FOUR_COUNT = 1;

    private static final int FIELD_SIZE = 10;

    private Game game;
    private Scanner scanner = new Scanner(System.in);

    private FieldRenderer renderer = new FieldRenderer();
    private FieldController fieldController = new FieldController();
    private ShipController shipController = new ShipController();

    private List<Integer> shipSizeList;

    public Application() {
        shipSizeList = new ArrayList<>();
        for (int i = 0; i < SHIP_FOUR_COUNT; i++) {
            shipSizeList.add(4);
        }
        for (int i = 0; i < SHIP_THREE_COUNT; i++) {
            shipSizeList.add(3);
        }
        for (int i = 0; i < SHIP_TWO_COUNT; i++) {
            shipSizeList.add(2);
        }
        for (int i = 0; i < SHIP_ONE_COUNT; i++) {
            shipSizeList.add(1);
        }
    }

    public void start() {
        initGame();

        placeShips(game.getPlayer1(), "Player1");
        placeShips(game.getPlayer2(), "Player2");
        
        player1Turn();

    }
    
    private void player1Turn() {
        System.out.println("Player1 -> turn");
        System.out.println("My field:");
        renderer.renderOwnField(game.getPlayer1().getOwnField());
        System.out.println("Enemy field");
        renderer.renderEnemyField(game.getPlayer1().getEnemyField());
        System.out.println("Fire");
        String fireAimStr = scanner.nextLine();
        int j = fireAimStr.charAt(0) - 'a';
        int i = Integer.valueOf(fireAimStr.substring(1)) - 1;
        if (indexOutOfBounds(i) || indexOutOfBounds(j)) {
            System.out.println("there is no such cell");
        }
        if (fieldController.makeShoot(game.getPlayer1().getEnemyField(), i, j)) {
            if (game.isPlayer1Winner()) {
                System.out.println("Player1 - Winner");
            } else {
                player1Turn();
            }
        } else {
            player2Turn();
        }
    }

    private void player2Turn() {
        System.out.println("Player2 -> turn");
        System.out.println("My field:");
        renderer.renderOwnField(game.getPlayer2().getOwnField());
        System.out.println("Enemy field");
        renderer.renderEnemyField(game.getPlayer2().getEnemyField());
        System.out.println("Fire");
        String fireAimStr = scanner.nextLine();
        int j = fireAimStr.charAt(0) - 'a';
        int i = Integer.valueOf(fireAimStr.substring(1)) - 1;
        if (fieldController.makeShoot(game.getPlayer2().getEnemyField(), i, j)) {
            if (game.isPlayer2Winner()) {
                System.out.println("Player2 - Winner");
            } else {
                player2Turn();
            }
        } else {
            player1Turn();
        }
    }

    private void initGame() {
        game = new Game();
        Player player1 = new Player();
        Player player2 = new Player();
        Field player1Field = new Field();
        Field player2Field = new Field();
        player1.setOwnField(player1Field);
        player1.setEnemyField(player2Field);
        player2.setOwnField(player2Field);
        player2.setEnemyField(player1Field);
        game.setPlayer1(player1);
        game.setPlayer2(player2);
    }

    private void placeShips(Player player, String name) {
        Character menu = '-';
        int tempSizeIndex = 0;
        Ship tempShip = new Ship(shipSizeList.get(tempSizeIndex));

        while (menu != '+' || tempSizeIndex == 0) {
            System.out.println(name + " placeShips");
            System.out.println();
            renderer.renderFieldWithNewShip(player.getOwnField(), tempShip);


            menu = scanner.nextLine().trim().charAt(0);
            switch (menu) {
                case 's': shipController.tryMoveDown(tempShip); break;
                case 'w': shipController.tryMoveUp(tempShip); break;
                case 'a': shipController.tryMoveLeft(tempShip); break;
                case 'd': shipController.tryMoveRight(tempShip); break;
                case 'r': shipController.tryRotate(tempShip); break;
                case 'p':
                    if (fieldController.tryAddShip(player.getOwnField(), tempShip)) {
                        tempSizeIndex++;
                        tempShip = new Ship(shipSizeList.get(tempSizeIndex));
                        if (tempSizeIndex == 10)
                            menu = '+';
                    }
                    break;
                case 'c':
                    fieldController.clear(player.getOwnField());
                    tempSizeIndex = 0;
                    tempShip = new Ship(shipSizeList.get(tempSizeIndex));
                    break;
            }
        }
    }

    private boolean indexOutOfBounds(int i) {
        if (i < 0 || i >= FIELD_SIZE) {
            return true;
        }
        return false;
    }


}
