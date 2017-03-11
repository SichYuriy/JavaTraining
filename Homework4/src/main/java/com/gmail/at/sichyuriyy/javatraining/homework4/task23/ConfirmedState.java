package com.gmail.at.sichyuriyy.javatraining.homework4.task23;

import com.sun.org.apache.xpath.internal.operations.Or;

/**
 * Created by Yuriy on 3/10/2017.
 */
public class ConfirmedState implements OrderState {

    private static final String ERROR_MESSAGE = "Order is already confirmed";

    private Order order;


    public ConfirmedState(Order order) {
        this.order = order;
    }

    @Override
    public void consider() {
        throw new IllegalStateException(ERROR_MESSAGE);
    }

    @Override
    public void cancel() {
        order.setOrderState(new CanceledState(order));
        order.setState(Order.State.CANCELED);
    }

    @Override
    public void deffer() {
        throw new IllegalStateException(ERROR_MESSAGE);
    }

    @Override
    public void confirm() {
        throw new IllegalStateException(ERROR_MESSAGE);
    }

    @Override
    public void deny() {
        throw new IllegalStateException(ERROR_MESSAGE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConfirmedState that = (ConfirmedState) o;

        return order != null ? order.equals(that.order) : that.order == null;
    }

    @Override
    public int hashCode() {
        return order != null ? order.hashCode() : 0;
    }
}
