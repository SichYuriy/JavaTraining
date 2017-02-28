package com.gmail.at.sichyuriyy.javatraining.homework3.task15;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 23.02.2017.
 */
public class MyPriorityQueueImplTest {

    private String list = "[2, -3, 2, 6, 5, 5, -3, 12, 7, 3]";
    private String expectedPQ = "PQ:[12, 7, 5, 6, 5, 2, -3, 2, -3, 3]";

    @Test(expected = IllegalArgumentException.class)
    public void createFromCollectionWithNull() throws Exception {
        List<Integer> list = new ArrayList<>();
        list.add(null);
        list.add(1);
        MyPriorityQueue<Integer> pq = new MyPriorityQueueImpl<>(list);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createFromArrayWithNull() throws Exception {
       Integer[]arr = new Integer[]{null, 1};
        MyPriorityQueue<Integer> pq = new MyPriorityQueueImpl<>(arr);
    }

    @Test
    public void createFromCollection() {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(-3);
        list.add(2);
        list.add(6);
        list.add(5);
        list.add(5);
        list.add(-3);
        list.add(12);
        list.add(7);
        list.add(3);

        MyPriorityQueue<Integer> pq = new MyPriorityQueueImpl<>(list,
                Comparator.reverseOrder());
        String expected = expectedPQ;
        String actual = pq.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void createFromArray() {
        Integer []arr = new Integer[]{2, -3, 2, 6, 5, 5, -3, 12, 7, 3};
        MyPriorityQueue<Integer> pq = new MyPriorityQueueImpl<>(arr,
                Comparator.reverseOrder());
        String expected = expectedPQ;
        String actual = pq.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void createFromCollectionNullComparator() {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(-3);
        list.add(2);


        MyPriorityQueue<Integer> pq = new MyPriorityQueueImpl<>(list);
        String expected = "PQ:[-3, 2, 2]";
        String actual = pq.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void createFromArrayNullComparator() {
        Integer []arr = new Integer[]{2, -3, 2};
        MyPriorityQueue<Integer> pq = new MyPriorityQueueImpl<>(arr);
        String expected = "PQ:[-3, 2, 2]";
        String actual = pq.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void add() {
        Integer []arr = new Integer[]{2, -3, 2, 6, 5, 5, -3, 12, 7, 3};
        MyPriorityQueue<Integer> pq = new MyPriorityQueueImpl<>(arr,
                Comparator.reverseOrder());
        pq.add(7);
        String expected = "PQ:[12, 7, 5, 6, 7, 2, -3, 2, -3, 3, 5]";
        String actual = pq.toString();
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addNull() {
        MyPriorityQueue<Integer> pq = new MyPriorityQueueImpl<>();
        pq.add(null);
    }

    @Test
    public void poll() {
        Integer []arr = new Integer[]{2, -3, 2, 6, 5, 5, -3, 12, 7, 3};
        MyPriorityQueue<Integer> pq = new MyPriorityQueueImpl<>(arr,
                Comparator.reverseOrder());
        Integer head = pq.poll();
        Integer expectedHead = 12;
        assertEquals(expectedHead, head);
        String actualQueue = pq.toString();
        String expectedQueue = "PQ:[7, 6, 5, 3, 5, 2, -3, 2, -3]";
        assertEquals(expectedQueue, actualQueue);
    }

    @Test
    public void peek() {
        Integer []arr = new Integer[]{2, -3, 2, 6, 5, 5, -3, 12, 7, 3};
        MyPriorityQueue<Integer> pq = new MyPriorityQueueImpl<>(arr,
                Comparator.reverseOrder());
        Integer head = pq.peek();
        Integer expectedHead = 12;
        assertEquals(expectedHead, head);
    }

    @Test
    public void addToEmpty() {
        MyPriorityQueue<Integer> pq = new MyPriorityQueueImpl<>(
                Comparator.reverseOrder());
        pq.add(3);
        pq.add(1);
        pq.add(2);
        String expected = "PQ:[3, 1, 2]";
        String actual = pq.toString();
        assertEquals(expected, actual);
    }

}