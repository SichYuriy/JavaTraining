package com.gmail.at.sichyuriyy.javatraining.homework4.task20;

/**
 * Created by Yuriy on 3/9/2017.
 */
public enum Figure {

    FIGURE_I(4),
    FIGURE_J(4),
    FIGURE_L(4),
    FIGURE_O(4),
    FIGURE_S(4),
    FIGURE_T(4),
    FIGURE_Z(4),
    FIGURE_SUPER(5);

    private int cellCount;

    private Figure(int cellCount) {
        this.cellCount = cellCount;
    }

    public int getCellCount() {
        return cellCount;
    }

}
