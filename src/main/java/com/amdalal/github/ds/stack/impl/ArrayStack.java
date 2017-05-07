package com.amdalal.github.ds.stack.impl;

import com.amdalal.github.ds.stack.Stack;

public class ArrayStack<T> implements Stack<T> {

    private int capacity;

    private int size;

    private Object[] data;

    private int currentIndex;

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        data = new Object[capacity];
    }

    @Override
    public T push(T element) {
        if (size() >= capacity) {
            throw new ArrayIndexOutOfBoundsException();
        }
        data[currentIndex++] = element;
        size++;
        return element;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        size--;
        return (T) data[--currentIndex];
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
