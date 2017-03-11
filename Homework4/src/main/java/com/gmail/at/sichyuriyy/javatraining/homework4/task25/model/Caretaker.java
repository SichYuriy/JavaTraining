package com.gmail.at.sichyuriyy.javatraining.homework4.task25.model;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Yuriy on 3/11/2017.
 */
public class Caretaker {

    private Deque<Memento> mementoDeque = new LinkedList<>();

    public void push(Memento memento) {
        mementoDeque.addLast(memento);
    }

    public Memento poll() {
        if (mementoDeque.isEmpty()) {
            return null;
        }
        return mementoDeque.pollLast();
    }
}
