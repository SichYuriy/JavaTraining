package com.gmail.at.sichyuriyy.javatraining.homework4.task21;

import com.gmail.at.sichyuriyy.javatraining.homework4.task21.movingstrategy.FlyWalkMovingStrategy;
import com.gmail.at.sichyuriyy.javatraining.homework4.task21.movingstrategy.MovingStrategy;

/**
 * Created by Yuriy on 3/9/2017.
 */
public class Pegasus extends Personage {

    public Pegasus() {
        super(new FlyWalkMovingStrategy());
    }
}
