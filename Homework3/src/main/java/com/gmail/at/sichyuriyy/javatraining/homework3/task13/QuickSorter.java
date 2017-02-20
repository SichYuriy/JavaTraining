package com.gmail.at.sichyuriyy.javatraining.homework3.task13;

import java.util.*;

/**
 * Created by Yuriy on 20.02.2017.
 */
public class QuickSorter implements Sorter {

    @Override
    public <E> void sort(List<E> list, Comparator<? super E> comp) {
        if (list == null || comp == null) {
            throw new IllegalArgumentException();
        }
        Object[] arr = list.toArray();
        quickSort(arr, 0, arr.length, comp);
        ListIterator<E> it = list.listIterator();
        for (Object obj: arr) {
            it.next();
            it.set((E) obj);
        }
    }

    private void quickSort(Object[] arr, int from, int to, Comparator comp) {
        if (to - from < 2) {
            return;
        }
        int mid = partition(arr, from, to, comp);
        quickSort(arr, from, mid, comp);
        quickSort(arr, mid + 1, to, comp);
    }

    private int partition(Object[] arr, int from, int to, Comparator comp) {
        int size = to - from;
        int midIndex = from + (int) (Math.random() * size);
        Object midVal = arr[midIndex];
        swap(arr, midIndex, to - 1);
        int swapIndex = from;
        for (int i = from; i < to - 1; i++) {
            if (comp.compare(arr[i], midVal) < 0) {
                swap(arr, swapIndex, i);
                swapIndex++;
            }
        }
        swap(arr, swapIndex, to - 1);

        return swapIndex;
    }

    private void swap(Object[] arr, int i, int j) {
        Object p = arr[i];
        arr[i] = arr[j];
        arr[j] = p;
    }
}
