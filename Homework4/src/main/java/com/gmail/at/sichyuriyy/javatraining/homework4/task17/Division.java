package com.gmail.at.sichyuriyy.javatraining.homework4.task17;

/**
 * Created by Yuriy on 04.03.2017.
 */
public class Division implements ArithmeticExpression {

    private ArithmeticExpression left;
    private ArithmeticExpression right;

    public Division(ArithmeticExpression left, ArithmeticExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double getValue() {
        return left.getValue() / right.getValue();
    }
}
