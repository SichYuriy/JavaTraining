package com.gmail.at.sichyuriyy.javatraining.homework3.task14;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 23.02.2017.
 */
public class ListOperationsTest {



    @Test
    public void mergeAndSort() throws Exception {
        List<Integer> firstList = getFirstList();
        List<Integer> secondList = getSecondList();
        List<Integer> result = ListOperations.mergeAndSort(firstList,
                secondList,
                Comparator.naturalOrder());
        String expected = "[-3, -2, 1, 2, 2, 3, 3, 4, 5, 6]";
        String actual = result.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void mergeAndSortNaturalOrdering() throws Exception {
        List<Integer> firstList = getFirstList();
        List<Integer> secondList = getSecondList();
        List<Integer> result = ListOperations.mergeAndSort(firstList,
                secondList);
        String expected = "[-3, -2, 1, 2, 2, 3, 3, 4, 5, 6]";
        String actual = result.toString();
        assertEquals(expected, actual);
    }

    private List<Integer> getFirstList() {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(-3);
        list.add(2);
        list.add(6);
        list.add(5);
        return list;
    }

    private List<Integer> getSecondList() {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(-2);
        list.add(4);
        list.add(1);
        list.add(3);
        return list;
    }

}