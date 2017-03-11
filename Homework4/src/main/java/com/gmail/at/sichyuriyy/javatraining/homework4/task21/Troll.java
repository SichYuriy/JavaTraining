package com.gmail.at.sichyuriyy.javatraining.homework4.task21;

import com.gmail.at.sichyuriyy.javatraining.homework4.task21.movingstrategy.OnlyWalkMovingStrategy;

/**
 * Created by Yuriy on 3/10/2017.
 */
public class Troll extends Personage {

    public Troll() {
        super(new OnlyWalkMovingStrategy());
    }
}
