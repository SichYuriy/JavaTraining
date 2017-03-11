package com.gmail.at.sichyuriyy.javatraining.homework4.task23;

/**
 * Created by Yuriy on 3/10/2017.
 */
public class CreatedState implements OrderState {

    private static final String ERROR_MASSAGE = "Order is not considered";

    private Order order;

    public CreatedState(Order order) {
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
        order.setOrderState(new DeferredState(order));
        order.setState(Order.State.DEFERRED);
    }

    @Override
    public void confirm() {
        throw new IllegalStateException(ERROR_MASSAGE);
    }

    @Override
    public void deny() {
        throw new IllegalStateException(ERROR_MASSAGE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreatedState that = (CreatedState) o;

        return order != null ? order.equals(that.order) : that.order == null;
    }

    @Override
    public int hashCode() {
        return order != null ? order.hashCode() : 0;
    }
}
