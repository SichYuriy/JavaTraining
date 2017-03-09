package com.gmail.at.sichyuriyy.javatraining.homework4.task20;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 3/9/2017.
 */
public class FigureFactoryTest {

    @Test
    public void getRandomStandardFigure() throws Exception {
        Figure figure = FigureFactory.getRandomStandardFigure();
        assertEquals(4, figure.getCellCount());
    }

    @Test
    public void getRandomFigure() throws Exception {
        Figure figure = FigureFactory.getRandomFigure();
        assertTrue(Arrays.asList(Figure.values()).contains(figure));
    }

    @Test
    public void getSuperFigure() throws Exception {
        Figure figure = FigureFactory.getSuperFigure();
        assertEquals(5, figure.getCellCount());
    }

}