package com.gmail.at.sichyuriyy.javatraining.homework4.task21;

import com.gmail.at.sichyuriyy.javatraining.homework4.task21.movingstrategy.MagicFlyMovingStrategy;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 3/10/2017.
 */
public class HumanTest {

    @Test
    public void moveGround() {
        Human human = new Human();
        assertTrue(human.move(true));
    }
    
    @Test
    public void moveAir() {
        Human human = new Human();
        assertFalse(human.move(false));
    }

    @Test
    public void changeMovingStrategy() {
        Human human = new Human();
        human.changeMovingStrategy(new MagicFlyMovingStrategy());
        assertTrue(human.move(true));
        assertTrue(human.move(false));
    }
}