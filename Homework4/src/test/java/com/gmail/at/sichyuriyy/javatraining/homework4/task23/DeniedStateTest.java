package com.gmail.at.sichyuriyy.javatraining.homework4.task23;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 3/10/2017.
 */
public class DeniedStateTest {
    
    private Order order;
    private DeniedState deniedState;

    @Before
    public void setUp() {
        order = new Order();
        deniedState = new DeniedState(order);

    }

    @Test(expected = IllegalStateException.class)
    public void consider() {
        deniedState.consider();
    }

    @Test
    public void cancel() {
        deniedState.cancel();
        assertEquals(Order.State.CANCELED, order.getState());
        assertEquals(new CanceledState(order), order.getOrderState());
    }

    @Test(expected = IllegalStateException.class)
    public void deffer() {
        deniedState.deffer();
    }

    @Test(expected = IllegalStateException.class)
    public void confirm() {
        deniedState.confirm();
    }

    @Test(expected = IllegalStateException.class)
    public void deny() {
        deniedState.deny();
    }

}