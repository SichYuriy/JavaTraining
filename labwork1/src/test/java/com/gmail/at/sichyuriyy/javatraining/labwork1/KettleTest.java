package com.gmail.at.sichyuriyy.javatraining.labwork1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 15.02.2017.
 */
public class KettleTest {
    
    @Test(expected = IllegalArgumentException.class)
    public void getKettleNegative() throws Exception {
        Kettle.getKettle(-2, 20);
    }

    @Test
    public void workSuccess() throws Exception {
        Kettle kettle = Kettle.getKettle(40, 4);
        kettle.turnOn();
        String expected = "Kettle is working";
        String actual = kettle.work();
    }

    @Test
    public void workFail() throws Exception {
        Kettle kettle = Kettle.getKettle(40, 4);
        String expected = "Kettle is unable to work without being turned on";
        String actual = kettle.work();
    }

}