package com.gmail.at.sichyuriyy.javatraining.homework4.task23;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 3/10/2017.
 */
public class DeferredStateTest {

    private Order order;
    private DeferredState deferredState;

    @Before
    public void setUp() {
        order = new Order();
        deferredState = new DeferredState(order);

    }

    @Test
    public void consider() {
        deferredState.consider();
        assertEquals(Order.State.CONSIDERING, order.getState());
        assertEquals(new ConsideringState(order), order.getOrderState());
    }

    @Test
    public void cancel() {
        deferredState.cancel();
        assertEquals(Order.State.CANCELED, order.getState());
        assertEquals(new CanceledState(order), order.getOrderState());
    }

    @Test(expected = IllegalStateException.class)
    public void deffer() {
        deferredState.deffer();
    }

    @Test
    public void confirm() {
        deferredState.confirm();
        assertEquals(Order.State.CONFIRMED, order.getState());
        assertEquals(new ConfirmedState(order), order.getOrderState());
    }

    @Test
    public void deny() {
        deferredState.deny();
        assertEquals(Order.State.DENIED, order.getState());
        assertEquals(new DeniedState(order), order.getOrderState());
    }

}