package com.gmail.at.sichyuriyy.javatraining.homework4.task21;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 3/10/2017.
 */
public class VampireTest {

    @Test
    public void moveGround() {
        Harpy harpy = new Harpy();
        assertTrue(harpy.move(true));
    }

    @Test
    public void moveAir() {
        Harpy harpy = new Harpy();
        assertTrue(harpy.move(false));
    }

}