package com.gmail.at.sichyuriyy.javatraining.homework2.task3;

/**
 * Created by Yuriy on 13.02.2017.
 */
public interface MyList<E> extends Iterable<E> {

    int size();
    E get(int index);
    void set(int index, E val);
    void add(E val);
    void add(int index, E val);
    void remove(E val);
    void remove(int index);
    boolean contains(E val);
    boolean isEmpty();

}
