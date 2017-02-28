package com.gmail.at.sichyuriyy.javatraining.homework3.task11;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Yuriy on 23.02.2017.
 */
public class FactoryTest {

    @Test
    public void createA() {
        Factory factory = new Factory(5);
        A createdObject = factory.createA();
        assertNotNull(createdObject);
    }

    @Test
    public void createMaximumObjects() {
        int max = 5;
        Factory factory = new Factory(max);
        List<A> list  = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            list.add(factory.createA());
        }
    }

    @Test(expected = IllegalStateException.class)
    public void createMoreThenMaximumObjects() {
        int max = 5;
        Factory factory = new Factory(max);
        List<A> list  = new ArrayList<>();
        for (int i = 0; i < max + 1; i++) {
            list.add(factory.createA());
        }
    }


    @Test
    public void createAfterFinalization() {
        int max = 1;
        Factory factory = new Factory(max);
        A object = factory.createA();
        object = null;
        Runtime.getRuntime().gc();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        object = factory.createA();
        assertNotNull(object);
    }


}