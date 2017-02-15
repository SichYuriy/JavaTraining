package com.gmail.at.sichyuriyy.javatraining.labwork1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 15.02.2017.
 */
public class CoffeeMachineTest {
    
    @Test(expected = IllegalArgumentException.class)
    public void getCoffeeMachine() throws Exception {
        CoffeeMachine.getCoffeeMachine(-2, 2);
    }

    @Test
    public void workSuccess() throws Exception {
        CoffeeMachine coffeeMachine = CoffeeMachine.getCoffeeMachine(40, 4);
        coffeeMachine.turnOn();
        String expected = "Coffee making in process";
        String actual = coffeeMachine.work();
    }

    @Test
    public void workFail() throws Exception {
        CoffeeMachine coffeeMachine = CoffeeMachine.getCoffeeMachine(40, 4);
        String expected = "Coffee machine is unable to work without being turned on";
        String actual = coffeeMachine.work();
    }

}