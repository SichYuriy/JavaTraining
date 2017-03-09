package com.gmail.at.sichyuriyy.javatraining.homework4.task16.model;

/**
 * Created by Yuriy on 06.03.2017.
 */
public class Game {



    private Player player1;
    private Player player2;

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public boolean isPlayer1Winner() {
        return player1.getEnemyField().getShips().stream()
                .allMatch(Ship::isDead);
    }

    public boolean isPlayer2Winner() {
        return player2.getEnemyField().getShips().stream()
                .allMatch(Ship::isDead);
    }

}
