package com.gmail.at.sichyuriyy.javatraining.homework4.task16.model;

/**
 * Created by Yuriy on 06.03.2017.
 */
public class Cell {

    private int i;
    private int j;
    private boolean bombed;

    public Cell(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public boolean isBombed() {
        return bombed;
    }

    public void setBombed(boolean bombed) {
        this.bombed = bombed;
    }


}
