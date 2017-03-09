package com.gmail.at.sichyuriyy.javatraining.homework4.task20;

import java.util.Random;

/**
 * Created by Yuriy on 3/9/2017.
 */
public class FigureFactory {

    public static Figure getRandomStandardFigure() {
        Random random = new Random();
        int index = random.nextInt(Figure.values().length - 1);
        return Figure.values()[index];
    }

    public static Figure getRandomFigure() {
        Random random = new Random();
        int index = random.nextInt(Figure.values().length);
        return Figure.values()[index];
    }

    public static Figure getSuperFigure() {
        return Figure.FIGURE_SUPER;
    }
}
