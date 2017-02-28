package com.gmail.at.sichyuriyy.javatraining.homework3.task14;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Yuriy on 20.02.2017.
 */
public class ListOperations {

    private ListOperations() {}

    public static <E> List<E> mergeAndSort(List<? extends E> firstList,
                                           List<? extends E> secondList) {
        return mergeAndSort(firstList, secondList, null);
    }

    public static <E> List<E> mergeAndSort(List<? extends E> firstList,
                                           List<? extends E> secondList,
                                           Comparator<? super E> comp) {
        List<E> result = new ArrayList<>();
        result.addAll(firstList);
        result.addAll(secondList);
        result.sort(comp);
        return result;
    }

}
