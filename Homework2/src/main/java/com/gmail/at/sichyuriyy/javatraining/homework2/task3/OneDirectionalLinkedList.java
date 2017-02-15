package com.gmail.at.sichyuriyy.javatraining.homework2.task3;


/**
 * Created by Yuriy on 14.02.2017.
 */
public class OneDirectionalLinkedList<E> implements MyList<E> {


    private int size;
    private Node<E> head;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> temp = head;
        int tempIndex = 0;
        while (tempIndex < index) {
            temp = temp.getNext();
            tempIndex++;
        }
        return temp.getVal();
    }

    @Override
    public void set(int index, E val) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> temp = head;
        int tempIndex = 0;

        while (tempIndex < index) {
            temp = temp.getNext();
            tempIndex++;
        }
        temp.setVal(val);

    }

    @Override
    public void add(E val) {
        size++;
        if (size - 1 == 0) {
            head = new Node<>(val);
            return;
        }
        Node<E> temp = head;
        while (temp.hasNext()) {
            temp = temp.getNext();
        }
        temp.setNext(new Node<>(val));
    }

    @Override
    public void add(int index, E val) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        size++;
        if (size - 1 == 0) {
            head = new Node<>(val);
            return;
        }
        if (index == 0) {
            Node first = new Node<>(val, head);
            head = first;
            return;
        }
        Node<E> temp = head.getNext();
        Node<E> prev = head;
        int tempIndex = 1;
        while (tempIndex < index) {
            temp = temp.getNext();
            prev = prev.getNext();
            tempIndex++;
        }
        prev.setNext(new Node<>(val, temp));
    }

    @Override
    public void remove(E val) {
        if (val == null) {
            throw new IllegalArgumentException();
        }
        if (size == 0) {
            return;
        }
        if (val.equals(head.getVal())) {
            size--;
            head = head.getNext();
            return;
        }
        Node<E> temp = head.next;
        Node<E> prev = head;
        while (temp != null) {
            if (val.equals(temp.getVal())) {
                size--;
                prev.setNext(temp.getNext());
                return;
            }
            temp = temp.getNext();
            prev = prev.getNext();
        }
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            size--;
            head = head.getNext();
            return;
        }

        Node<E> temp = head.getNext();
        Node<E> prev = head;
        int tempIndex = 1;
        while (tempIndex < index) {
            temp = temp.getNext();
            prev = prev.getNext();
            tempIndex++;
        }
        prev.setNext(temp.getNext());;
    }

    @Override
    public boolean contains(E val) {
        if (val == null) {
            throw new IllegalArgumentException();
        }
        Node<E> temp = head;
        while (temp != null) {
            if (val.equals(temp.getVal())) {
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        String result = "[";
        Node<E> temp = head;
        while (temp.hasNext()) {
            result += temp.getVal() + ", ";
            temp = temp.getNext();
        }
        result += temp.getVal() + "]";
        return result;
    }

    private static class Node<E> {
        private E val;
        private Node<E> next;

        public Node(E val) {
            this.val = val;
        }

        public Node(E val, Node<E> next) {
            this.val = val;
            this.next = next;
        }

        public E getVal() {
            return val;
        }

        public void setVal(E val) {
            this.val = val;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public boolean hasNext() {
            return next != null;
        }
    }
}
