package com.gmail.at.sichyuriyy.javatraining.homework4.task21;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 3/10/2017.
 */
public class TrollTest {

    @Test
    public void moveGround() {
        Troll troll = new Troll();
        assertTrue(troll.move(true));
    }

    @Test
    public void moveAir() {
        Troll troll = new Troll();
        assertFalse(troll.move(false));
    }

}