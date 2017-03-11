package com.gmail.at.sichyuriyy.javatraining.homework4.task21;

import com.gmail.at.sichyuriyy.javatraining.homework4.task21.Personage;
import com.gmail.at.sichyuriyy.javatraining.homework4.task21.movingstrategy.FlyWalkMovingStrategy;

/**
 * Created by Yuriy on 3/9/2017.
 */
public class Vampire extends Personage {

    public Vampire() {
        super(new FlyWalkMovingStrategy());
    }
}
