package com.gmail.at.sichyuriyy.javatraining.homework2.task3;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 14.02.2017.
 */
public class OneDirectionalLinkedListTest extends MyListTest {

    @Override
    protected MyList<Integer> getTestedMyList() {
        return new OneDirectionalLinkedList<>();
    }
}