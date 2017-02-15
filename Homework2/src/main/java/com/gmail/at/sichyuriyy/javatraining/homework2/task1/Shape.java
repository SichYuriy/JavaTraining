package com.gmail.at.sichyuriyy.javatraining.homework2.task1;

/**
 * Created by Yuriy on 13.02.2017.
 */
public interface Shape {

    double getArea();

    default double plus(Shape other) {
        return this.getArea() + other.getArea();
    }

}
