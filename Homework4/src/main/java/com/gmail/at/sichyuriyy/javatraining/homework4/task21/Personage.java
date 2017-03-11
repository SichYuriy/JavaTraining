package com.gmail.at.sichyuriyy.javatraining.homework4.task21;

import com.gmail.at.sichyuriyy.javatraining.homework4.task21.movingstrategy.MovingStrategy;

/**
 * Created by Yuriy on 3/9/2017.
 */
public abstract class Personage {

    private MovingStrategy movingStrategy;

    public Personage(MovingStrategy movingStrategy) {
        this.movingStrategy = movingStrategy;
    }

    public void changeMovingStrategy(MovingStrategy movingStrategy) {
        this.movingStrategy = movingStrategy;
    }

    public boolean move(boolean isGroundReachable) {
        if (isGroundReachable) {
            return movingStrategy.moveToTheGroundPoint();
        } else {
            return movingStrategy.moveToTheSkyPoint();
        }
    }


}
