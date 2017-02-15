package com.gmail.at.sichyuriyy.javatraining.homework2.task2.impl;

import com.gmail.at.sichyuriyy.javatraining.homework2.task2.impl.Wheel;
import org.junit.Test;

/**
 * Created by Yuriy on 13.02.2017.
 */
public class WheelTest {

    @Test(expected = IllegalArgumentException.class)
    public void getWheelNegative() throws Exception {
        Wheel.getWheel(-2);
    }

}