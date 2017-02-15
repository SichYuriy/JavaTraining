package com.gmail.at.sichyuriyy.javatraining.homework2.task3;


import java.util.*;

/**
 * Created by Yuriy on 14.02.2017.
 */
public class BidirectionalLinkedList<E> implements MyList<E> {

    private int size;
    private Node<E> head;
    private Node<E> tail;

    int modCount = 0;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> temp = getNode(index);
        return temp.getVal();
    }

    @Override
    public void set(int index, E val) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> temp = getNode(index);
        temp.setVal(val);
    }

    @Override
    public void add(E val) {
        modCount++;
        size++;
        if (size - 1 == 0) {
            head = tail = new Node<>(val);
            return;
        }
        tail.setNext(new Node<>(val, tail, null));
        tail = tail.getNext();
    }

    @Override
    public void add(int index, E val) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        modCount++;
        size++;
        if (size - 1 == 0) {
            head = tail = new Node<>(val);
            return;
        }
        if (index == 0) {
            head.setPrev(new Node<>(val, null, head));
            head = head.getPrev();
            return;
        }
        if (index == size - 1) {
            tail.setNext(new Node<>(val, tail, null));
            tail = tail.getNext();
            return;
        }
        Node<E> temp = getNode(index);
        temp.getPrev().setNext(new Node<>(val, temp.getPrev(), temp));
    }

    @Override
    public void remove(E val) {
        if (val == null) {
            throw new IllegalArgumentException();
        }
        if (size == 1 && val.equals(head.getVal())) {
            size = 0;
            head = tail = null;
            modCount++;
            return;
        }

        Node<E> temp = head;
        while (temp != null) {
            if (val.equals(temp.getVal())) {
                deleteNode(temp);
                size--;
                modCount++;
                return;
            }
            temp = temp.getNext();
        }
    }


    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (size == 1) {
            head = tail = null;
            size--;
            modCount++;
            return;
        }
        Node<E> temp = getNode(index);
        deleteNode(temp);
        size--;
        modCount++;
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

    private void deleteNode(Node<E> node) {
        if (node == head) {
            head = head.getNext();
            head.setPrev(null);
        } else if (node == tail) {
            tail = tail.getPrev();
            tail.setNext(null);
        } else {
            node.getPrev().setNext(node.getNext());
        }
    }

    private Node<E> getNode(int index) {
        Node<E> temp;
        if (index < size / 2) {
            int tempIndex = 0;
            temp = head;
            while (tempIndex != index) {
                temp = temp.getNext();
                tempIndex++;
            }
        } else {
            int tempIndex = size - 1;
            temp = tail;
            while (tempIndex != index) {
                temp = temp.getPrev();
                tempIndex--;
            }
        }
        return temp;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyListIterator();
    }

    private class MyListIterator implements Iterator<E> {

        private int tempModCount;
        private Node<E> tempNode;
        private Node<E> lastReturned;

        public MyListIterator() {
            this.tempModCount = modCount;
            this.tempNode = head;
        }

        @Override
        public boolean hasNext() {
            return tempNode != null;
        }

        @Override
        public E next() {
            checkForModification();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E result = tempNode.getVal();
            lastReturned = tempNode;
            tempNode = tempNode.getNext();
            return result;
        }

        @Override
        public void remove() {
            checkForModification();
            if (lastReturned == null) {
                throw new IllegalStateException();
            }
            deleteNode(lastReturned);
            size--;
            modCount++;
            tempModCount++;
        }

        private void checkForModification() {
            if (modCount != tempModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }

    private static class Node<E> {
        E val;
        Node<E> prev;
        Node<E> next;

        public Node(E val) {
            this.val = val;
        }

        public Node(E val, Node<E> prev, Node<E> next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }

        public E getVal() {
            return val;
        }

        public void setVal(E val) {
            this.val = val;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
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
