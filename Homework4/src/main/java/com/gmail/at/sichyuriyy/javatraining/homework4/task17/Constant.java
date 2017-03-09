package com.gmail.at.sichyuriyy.javatraining.homework4.task17;

/**
 * Created by Yuriy on 04.03.2017.
 */
public class Constant implements ArithmeticExpression {

    private double value;

    public Constant(double value) {
        this.value = value;
    }


    @Override
    public double getValue() {
        return value;
    }
}
