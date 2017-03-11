package com.gmail.at.sichyuriyy.javatraining.homework4.task23;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 3/10/2017.
 */
public class CreatedStateTest {
    
    private Order order;
    private CreatedState createdState;

    @Before
    public void setUp() {
        order = new Order();
        createdState = new CreatedState(order);
    }

    @Test
    public void consider() {
        createdState.consider();
        assertEquals(Order.State.CONSIDERING, order.getState());
        assertEquals(new ConsideringState(order), order.getOrderState());
    }

    @Test
    public void cancel() {
        createdState.cancel();
        assertEquals(Order.State.CANCELED, order.getState());
        assertEquals(new CanceledState(order), order.getOrderState());
    }

    @Test
    public void deffer() {
        createdState.deffer();
        assertEquals(Order.State.DEFERRED, order.getState());
        assertEquals(new DeferredState(order), order.getOrderState());
    }

    @Test(expected = IllegalStateException.class)
    public void confirm() {
        createdState.confirm();
    }

    @Test(expected = IllegalStateException.class)
    public void deny() {
        createdState.deny();
    }

}