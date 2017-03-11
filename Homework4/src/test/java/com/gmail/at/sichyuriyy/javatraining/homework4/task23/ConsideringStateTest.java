package com.gmail.at.sichyuriyy.javatraining.homework4.task23;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 3/10/2017.
 */
public class ConsideringStateTest {

    private Order order;
    private ConsideringState consideringState;

    @Before
    public void setUp() {
        order = new Order();
        consideringState = new ConsideringState(order);
    }

    @Test(expected = IllegalStateException.class)
    public void consider() {
        consideringState.consider();
    }

    @Test
    public void cancel() {
        consideringState.cancel();
        assertEquals(Order.State.CANCELED, order.getState());
        assertEquals(new CanceledState(order), order.getOrderState());
    }

    @Test
    public void deffer() {
        consideringState.deffer();
        assertEquals(Order.State.DEFERRED, order.getState());
        assertEquals(new DeferredState(order), order.getOrderState());
    }

    @Test
    public void confirm() {
        consideringState.confirm();
        assertEquals(Order.State.CONFIRMED, order.getState());
        assertEquals(new ConfirmedState(order), order.getOrderState());
    }

    @Test
    public void deny() {
        consideringState.deny();
        assertEquals(Order.State.DENIED, order.getState());
        assertEquals(new DeniedState(order), order.getOrderState());
    }

}