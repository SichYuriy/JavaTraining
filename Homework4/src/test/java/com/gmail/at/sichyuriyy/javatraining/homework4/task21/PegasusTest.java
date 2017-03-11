package com.gmail.at.sichyuriyy.javatraining.homework4.task21;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 3/10/2017.
 */
public class PegasusTest {
    
    @Test
    public void moveGround() {
        Pegasus pegasus = new Pegasus();
        assertTrue(pegasus.move(true));
    }

    @Test
    public void moveAir() {
        Pegasus pegasus = new Pegasus();
        assertTrue(pegasus.move(false));
    }

}