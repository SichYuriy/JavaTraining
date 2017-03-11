package com.gmail.at.sichyuriyy.javatraining.homework4.task26;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 3/11/2017.
 */
public class BacteriumTest {


    @Test
    public void createBacterium() {
        BacteriumDataFactory factory = new BacteriumDataFactory();

        Bacterium bacteriumType1One = Bacterium.createBacterium(Type.TYPE1, factory);
        Bacterium bacteriumType1Two = Bacterium.createBacterium(Type.TYPE1, factory);
        Bacterium bacteriumType2One = Bacterium.createBacterium(Type.TYPE2, factory);
        Bacterium bacteriumType2Two = Bacterium.createBacterium(Type.TYPE2, factory);

        assertTrue(bacteriumType1One.getBigData() == bacteriumType1Two.getBigData());
        assertTrue(bacteriumType2One.getBigData() == bacteriumType2Two.getBigData());
        assertFalse(bacteriumType1One.getBigData() == bacteriumType2One.getBigData());

    }

}