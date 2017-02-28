package com.gmail.at.sichyuriyy.javatraining.homework3.task13;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 23.02.2017.
 */
public class QuickSorterTest extends SorterTest {

    @Override
    public Sorter getTestedSorter() {
        return new QuickSorter();
    }
}