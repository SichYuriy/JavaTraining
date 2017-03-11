package com.gmail.at.sichyuriyy.javatraining.homework4.task21.movingstrategy;

/**
 * Created by Yuriy on 3/9/2017.
 */
public class FlyWalkMovingStrategy implements MovingStrategy {

    @Override
    public boolean moveToTheGroundPoint() {
        System.out.println("I am moving to the point along the ground.");
        return true;
    }

    @Override
    public boolean moveToTheSkyPoint() {
        System.out.println("I am flying to this point.");
        return true;
    }
}
