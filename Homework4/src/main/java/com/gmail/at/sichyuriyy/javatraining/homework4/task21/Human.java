package com.gmail.at.sichyuriyy.javatraining.homework4.task21;

import com.gmail.at.sichyuriyy.javatraining.homework4.task21.movingstrategy.MovingStrategy;
import com.gmail.at.sichyuriyy.javatraining.homework4.task21.movingstrategy.OnlyWalkMovingStrategy;

/**
 * Created by Yuriy on 3/9/2017.
 */
public class Human extends Personage {

    public Human() {
        super(new OnlyWalkMovingStrategy());
    }
}
