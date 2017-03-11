package com.gmail.at.sichyuriyy.javatraining.homework4.task23;

/**
 * Created by Yuriy on 3/10/2017.
 */
public class CanceledState implements OrderState {

    private static final String ERROR_MASSAGE = "Order is already canceled";

    private Order order;

    public CanceledState(Order order) {
        this.order = order;
    }

    @Override
    public void consider() {
        throw new IllegalStateException(ERROR_MASSAGE);
    }

    @Override
    public void cancel() {
        throw new IllegalStateException(ERROR_MASSAGE);
    }

    @Override
    public void deffer() {
        throw new IllegalStateException(ERROR_MASSAGE);

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

        CanceledState that = (CanceledState) o;

        return order != null ? order.equals(that.order) : that.order == null;
    }

    @Override
    public int hashCode() {
        return order != null ? order.hashCode() : 0;
    }
}
