package com.gmail.at.sichyuriyy.javatraining.homework4.task21;

import com.gmail.at.sichyuriyy.javatraining.homework4.task21.movingstrategy.MovingStrategy;
import com.gmail.at.sichyuriyy.javatraining.homework4.task21.movingstrategy.OnlyWalkMovingStrategy;

/**
 * Created by Yuriy on 3/9/2017.
 */
public class Orc extends Personage {

    public Orc() {
        super(new OnlyWalkMovingStrategy());
    }
}
