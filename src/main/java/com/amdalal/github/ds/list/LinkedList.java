package com.amdalal.github.ds.list;

public interface LinkedList<T> {

    T pushFront(T element);

    T getFront();

    T popFront();

    T pushBack(T element);

    T getBack();

    boolean isEmpty();

    int size();

    T elementAt(int index);
}
