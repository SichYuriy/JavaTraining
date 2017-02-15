package com.gmail.at.sichyuriyy.javatraining.homework2.task2;

import com.gmail.at.sichyuriyy.javatraining.homework2.task2.impl.Wheel;

/**
 * Created by Yuriy on 13.02.2017.
 */
public interface Car {

    int drive(int meters);
    void refill(double liters);

    double getFuelAmount();
    double getMaxFuelAmount();

    void changeFrontLeftWheel(Wheel wheel);
    void changeFrontRightWheel(Wheel wheel);
    void changeBackLeftWheel(Wheel wheel);
    void changeBackRightWheel(Wheel wheel);

    String getBrand();

}
