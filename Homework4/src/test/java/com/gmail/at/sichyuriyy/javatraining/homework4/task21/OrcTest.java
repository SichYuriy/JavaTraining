package com.gmail.at.sichyuriyy.javatraining.homework4.task21;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 3/10/2017.
 */
public class OrcTest {
    
    @Test
    public void moveGround() {
        Orc orc = new Orc();
        assertTrue(orc.move(true));
    }

    @Test
    public void moveAir() {
        Orc orc = new Orc();
        assertFalse(orc.move(false));
    }

}