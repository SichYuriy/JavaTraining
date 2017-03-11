package com.gmail.at.sichyuriyy.javatraining.homework4.task23;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 3/10/2017.
 */
public class ConfirmedStateTest {
    
    private Order order;
    private ConfirmedState confirmedState;

    @Before
    public void setUp() {
        order = new Order();
        confirmedState = new ConfirmedState(order);
    }

    @Test(expected = IllegalStateException.class)
    public void consider() {
        confirmedState.consider();
    }

    @Test
    public void cancel() {
        confirmedState.cancel();
        assertEquals(Order.State.CANCELED, order.getState());
        assertEquals(new CanceledState(order), order.getOrderState());
    }

    @Test(expected = IllegalStateException.class)
    public void deffer() {
        confirmedState.deffer();
    }

    @Test(expected = IllegalStateException.class)
    public void confirm() {
        confirmedState.confirm();
    }

    @Test(expected = IllegalStateException.class)
    public void deny() {
        confirmedState.deny();
    }

}