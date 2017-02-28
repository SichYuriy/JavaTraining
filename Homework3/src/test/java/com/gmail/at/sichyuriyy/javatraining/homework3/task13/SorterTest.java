package com.gmail.at.sichyuriyy.javatraining.homework3.task13;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 23.02.2017.
 */
public abstract class SorterTest {

    private Sorter sorter;

    public abstract Sorter getTestedSorter();

    @Before
    public void setUp() {
        sorter = getTestedSorter();
    }

    @Test
    public void sortAscending() {
        List<Integer> list = getIntListToSort();
        String expected = "[-3, 2, 2, 5, 6]";
        sorter.sort(list, Comparator.naturalOrder());
        String actual = list.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void sortDescending() {
        List<Integer> list = getIntListToSort();
        String expected = "[6, 5, 2, 2, -3]";
        sorter.sort(list, Comparator.reverseOrder());
        String actual = list.toString();
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void sortNullComparator() {
        List<Integer> list = getIntListToSort();
        String expected = "[6, 5, 2, 2, -3]";
        sorter.sort(list, null);
    }

    private List<Integer> getIntListToSort() {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(-3);
        list.add(2);
        list.add(6);
        list.add(5);
        return list;
    }


}