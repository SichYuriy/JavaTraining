package com.gmail.at.sichyuriyy.javatraining.homework2.task2.impl;

import com.gmail.at.sichyuriyy.javatraining.homework2.task2.impl.Motor;
import org.junit.Test;

/**
 * Created by Yuriy on 13.02.2017.
 */
public class MotorTest {

    @Test(expected = IllegalArgumentException.class)
    public void getMotorNegative() throws Exception {
        Motor.getMotor(-2);
    }

}