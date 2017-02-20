package com.gmail.at.sichyuriyy.javatraining.homework3.task13;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Yuriy on 20.02.2017.
 */
public interface Sorter {

    <E> void sort(List<E> list, Comparator<? super E> comp);
}
