package com.gmail.at.sichyuriyy.javatraining.homework2.task3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 14.02.2017.
 */
public abstract class MyListTest {

    private MyList<Integer> list;

    protected abstract MyList<Integer> getTestedMyList();

    @Before
    public void setUp() throws Exception {
        list = getTestedMyList();
        list.add(1);
        list.add(-2);
        list.add(5);
        list.add(123);
        list.add(12);
    }

    @After
    public void tearDown() throws Exception {
        list = null;
    }

    @Test
    public void size() throws Exception {
        int expectedSize = 5;
        int actualSize = list.size();
        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void get() throws Exception {
        int expectedValue = 123;
        int actualValue = list.get(3);
        assertEquals(expectedValue, actualValue);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getNegativeIndex() throws Exception {
        list.get(-3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getLargeIndex() throws Exception {
        list.get(5);
    }

    @Test
    public void set() throws Exception {
        int index = 2;
        int val = 23;
        list.set(index, val);
        String expected = "[1, -2, 23, 123, 12]";
        String actual = list.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void setFirst() throws Exception {
        int index = 0;
        int val = 23;
        list.set(index, val);
        String expected = "[23, -2, 5, 123, 12]";
        String actual = list.toString();
        assertEquals(expected, actual);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setNegativeIndex() throws Exception {
        list.set(-2, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setLargeIndex() throws Exception {
        list.set(5, 0);
    }

    @Test
    public void add() throws Exception {
        int index = 1;
        int val = 23;
        list.add(index, val);
        String expected = "[1, 23, -2, 5, 123, 12]";
        String actual = list.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void addFirst() throws Exception {
        int index = 0;
        int val = 23;
        list.add(index, val);
        String expected = "[23, 1, -2, 5, 123, 12]";
        String actual = list.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void addFirstInEmpty() throws Exception {
        MyList<Integer> list = getTestedMyList();
        int index = 0;
        int val = 23;
        list.add(index, val);
        String expected = "[23]";
        String actual = list.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void addLast() throws Exception {
        int index = 5;
        int val = 23;
        list.add(index, val);
        String expected = "[1, -2, 5, 123, 12, 23]";
        String actual = list.toString();
        assertEquals(expected, actual);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addNegativeIndex() throws Exception {
        list.add(-2, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addLargeIndex() throws Exception {
        list.add(6, 0);
    }

    @Test
    public void remove() throws Exception {
        list.remove(Integer.valueOf(5));
        String expected = "[1, -2, 123, 12]";
        String actual = list.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void removeEmpty() throws Exception {
        MyList<Integer> list = getTestedMyList();
        list.remove(Integer.valueOf(5));
        String expected = "[]";
        String actual = list.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void removeNonExist() throws Exception {
        list.remove(Integer.valueOf(7));
        String expected = "[1, -2, 5, 123, 12]";
        String actual = list.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void removeLast() throws Exception {
        MyList<Integer> list = getTestedMyList();
        list.add(7);
        list.remove((Integer)7);
        String expected = "[]";
        String actual = list.toString();
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeNull() throws Exception {
        list.remove(null);
    }

    @Test
    public void removeIndex() throws Exception {
        list.remove(2);
        String expected = "[1, -2, 123, 12]";
        String actual = list.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void removeIndexFirst() throws Exception {
        list.remove(0);
        String expected = "[-2, 5, 123, 12]";
        String actual = list.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void removeIndexLast() throws Exception {
        list.remove(4);
        String expected = "[1, -2, 5, 123]";
        String actual = list.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void removeIndexOneElem() throws Exception {
        MyList<Integer> list = getTestedMyList();
        list.add(1);
        list.remove(0);
        String expected = "[]";
        String actual = list.toString();
        assertEquals(expected, actual);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeNegativeIndex() throws Exception {
        list.remove(-2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeLargeIndex() throws Exception {
        list.remove(6);
    }

    @Test
    public void contains() throws Exception {
        assertTrue(list.contains(5));
    }

    @Test
    public void containsNonExistVal() throws Exception {
        assertFalse(list.contains(9));
    }

    @Test(expected = IllegalArgumentException.class)
    public void containsNull() throws Exception {
        list.contains(null);
    }

    @Test
    public void isEmpty() throws Exception {
        assertFalse(list.isEmpty());
    }

    @Test
    public void isEmptyOnEmpty() throws Exception {
        MyList<Integer> list = getTestedMyList();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testToString() throws Exception {
        String expected = "[1, -2, 5, 123, 12]";
        String actual = list.toString();
        assertEquals(expected, actual);
    }
}