package com.amdalal.github.ds.stack;

public interface Stack<T> {

    T push(T element);

    T pop();

    boolean isEmpty();

    int size();

}
