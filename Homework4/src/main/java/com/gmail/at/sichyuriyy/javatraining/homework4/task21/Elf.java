package com.gmail.at.sichyuriyy.javatraining.homework4.task21;

import com.gmail.at.sichyuriyy.javatraining.homework4.task21.movingstrategy.MagicFlyMovingStrategy;
import com.gmail.at.sichyuriyy.javatraining.homework4.task21.movingstrategy.MovingStrategy;

/**
 * Created by Yuriy on 3/9/2017.
 */
public class Elf extends Personage {

    public Elf() {
        super(new MagicFlyMovingStrategy());
    }
}
