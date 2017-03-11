package com.gmail.at.sichyuriyy.javatraining.homework4.task23;

/**
 * Created by Yuriy on 3/10/2017.
 */
public class DeferredState implements OrderState {

    private static final String ERROR_MESSAGE = "Order is already deferred";

    private Order order;

    public DeferredState(Order order) {
        this.order = order;
    }

    @Override
    public void consider() {
        order.setOrderState(new ConsideringState(order));
        order.setState(Order.State.CONSIDERING);
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
        order.setOrderState(new ConfirmedState(order));
        order.setState(Order.State.CONFIRMED);
    }

    @Override
    public void deny() {
        order.setOrderState(new DeniedState(order));
        order.setState(Order.State.DENIED);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeferredState that = (DeferredState) o;

        return order != null ? order.equals(that.order) : that.order == null;
    }

    @Override
    public int hashCode() {
        return order != null ? order.hashCode() : 0;
    }
}
