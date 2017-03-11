package com.gmail.at.sichyuriyy.javatraining.homework4.task21;

import com.gmail.at.sichyuriyy.javatraining.homework4.task21.movingstrategy.OnlyFlyMovingStrategy;

/**
 * Created by Yuriy on 3/10/2017.
 */
public class Harpy extends Personage {

    public Harpy() {
        super(new OnlyFlyMovingStrategy());
    }
}
