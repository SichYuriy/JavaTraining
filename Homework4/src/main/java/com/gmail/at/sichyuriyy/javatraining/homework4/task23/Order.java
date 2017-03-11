package com.gmail.at.sichyuriyy.javatraining.homework4.task23;

/**
 * Created by Yuriy on 3/10/2017.
 */
public class Order {

    public enum State {
        CREATED, CONSIDERING, CONFIRMED, DENIED, CANCELED, DEFERRED
    }

    private OrderState orderState;
    private State state;

    public Order() {
        orderState = new CreatedState(this);
        state = State.CREATED;
    }

    public void consider() {
        orderState.consider();
    }

    public void cancel() {
        orderState.cancel();
    }

    public void deffer() {
        orderState.deffer();
    }

    public void confirm() {
        orderState.confirm();
    }

    public void deny() {
        orderState.deny();
    }

    OrderState getOrderState() {
        return orderState;
    }

    void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

    public State getState() {
        return state;
    }

    void setState(State state) {
        this.state = state;
    }
}
