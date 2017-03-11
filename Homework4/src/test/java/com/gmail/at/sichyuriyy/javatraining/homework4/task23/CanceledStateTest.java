package com.gmail.at.sichyuriyy.javatraining.homework4.task23;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 3/10/2017.
 */
public class CanceledStateTest {
    
    private CanceledState canceledState;

    @Before
    public void setUp() {
        Order order = new Order();
        canceledState = new CanceledState(order);
    }

    @Test(expected = IllegalStateException.class)
    public void consider(){
        canceledState.consider();
    }

    @Test(expected = IllegalStateException.class)
    public void cancel() {
        canceledState.cancel();
    }

    @Test(expected = IllegalStateException.class)
    public void deffer() {
        canceledState.deffer();
    }

    @Test(expected = IllegalStateException.class)
    public void confirm() {
        canceledState.confirm();
    }

    @Test(expected = IllegalStateException.class)
    public void deny() {
        canceledState.deny();
    }
}