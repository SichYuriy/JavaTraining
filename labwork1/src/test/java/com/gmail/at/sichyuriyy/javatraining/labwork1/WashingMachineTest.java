package com.gmail.at.sichyuriyy.javatraining.labwork1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 15.02.2017.
 */
public class WashingMachineTest {

    @Test(expected = IllegalArgumentException.class)
    public void getWashingMachineNegative() throws Exception {
        WashingMachine.getWashingMachine(-2, 2);
    }

    @Test
    public void workSuccess() throws Exception {
        WashingMachine washingMachine = WashingMachine.getWashingMachine(40, 4);
        washingMachine.turnOn();
        String expected = "Clothe washing in process";
        String actual = washingMachine.work();
    }

    @Test
    public void workFail() throws Exception {
        WashingMachine washingMachine = WashingMachine.getWashingMachine(40, 4);
        String expected = "Washing machine is unable to work without being turned on";
        String actual = washingMachine.work();
    }

}