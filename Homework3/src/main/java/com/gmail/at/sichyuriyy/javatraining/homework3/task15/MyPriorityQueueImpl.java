package com.gmail.at.sichyuriyy.javatraining.homework3.task15;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

/**
 * Created by Yuriy on 21.02.2017.
 */
public class MyPriorityQueueImpl<E> implements MyPriorityQueue<E> {

    ArrayList<E> queue;
    Comparator<? super E> comparator;


    public MyPriorityQueueImpl() {
        queue = new ArrayList<>();
    }

    public MyPriorityQueueImpl(E[] array) {
        this(array, null);
    }

    public MyPriorityQueueImpl(Collection<? extends E> collection) {
        this(collection, null);
    }

    public MyPriorityQueueImpl(Comparator<? super E> c) {
        this();
        comparator = c;
    }

    public MyPriorityQueueImpl(E[] arr, Comparator<? super E> c) {
        queue = new ArrayList<>(arr.length);
        comparator = c;
        for (E val: arr) {
            if(val == null) {
                throw new IllegalArgumentException();
            }
            queue.add(val);
        }
        heapify();
    }

    public MyPriorityQueueImpl(Collection<? extends E> collection, Comparator<? super E> c) {
        queue = new ArrayList<>(collection.size());
        comparator = c;
        for (E val: collection) {
            if (val == null) {
                throw new IllegalArgumentException();
            }
            queue.add(val);
        }
        heapify();
    }

    @Override
    public void add(E val) {
        if (val == null) {
            throw new IllegalArgumentException();
        }
        queue.add(val);
        int tempIndex = queue.size() - 1;
        while (tempIndex != 0) {
            int parentIndex = getParentIndex(tempIndex);
            E tempVal = queue.get(tempIndex);
            E parentVal = queue.get(parentIndex);
            if (compare(tempVal, parentVal) < 0) {
                swap(tempIndex, parentIndex);
            }
            tempIndex = parentIndex;
        }
    }

    @Override
    public E poll() {
        E result = queue.get(0);
        swap(0, queue.size() - 1);
        queue.remove(queue.size() - 1);
        shiftDown(0);
        return result;
    }

    @Override
    public E peek() {
        return queue.get(0);
    }

    private void heapify() {
        for (int i = queue.size() / 2; i >= 0; i--) {
            shiftDown(i);
        }
    }

    private void shiftDown(int index) {
        int leftChildIndex = getLeftChildIndex(index);
        int rightChildIndex = getRightChildIndex(index);
        int minIndex = index;
        if (leftChildIndex < queue.size()
                && compare(queue.get(leftChildIndex), queue.get(minIndex)) < 0) {
            minIndex = leftChildIndex;
        }
        if (rightChildIndex < queue.size()
                && compare(queue.get(rightChildIndex), queue.get(minIndex)) < 0) {
            minIndex = rightChildIndex;
        }
        if (minIndex != index) {
            swap(index, minIndex);
            shiftDown(minIndex);
        }
    }

    private int getParentIndex(int index) {
        return (index + 1) / 2 - 1;
    }

    private int getLeftChildIndex(int index) {
        return (index + 1) * 2 - 1;
    }

    private int getRightChildIndex(int index) {
        return (index + 1) * 2;
    }

    private int compare(E val1, E val2) {
        if (comparator != null) {
            return comparator.compare(val1, val2);
        }
        return ((Comparable<? super E>) val1).compareTo(val2);
    }

    private void swap(int index1, int index2) {
        E temp = queue.get(index1);
        queue.set(index1, queue.get(index2));
        queue.set(index2, temp);
    }

    @Override
    public String toString() {
        return "PQ:" + queue.toString();
    }
}
