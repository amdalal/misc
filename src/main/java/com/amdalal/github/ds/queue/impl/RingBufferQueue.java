package com.amdalal.github.ds.queue.impl;

import com.amdalal.github.ds.queue.Queue;

public class RingBufferQueue<T> implements Queue<T> {

    private Object[] data;

    /**
     * Where are we going to write next.
     */
    private int writeIdx;

    private int size;

    public RingBufferQueue(int capacity) {
        this.data = new Object[capacity];
    }

    @Override
    public T enqueue(T element) {
        if (!isEmpty() && size == data.length) {
            throw new IllegalStateException();
        }
        if (writeIdx >= data.length) {
            writeIdx = 0;
        }
        data[writeIdx++] = element;
        size++;
        return element;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        int readIdx;
        if (writeIdx >= size) {
            readIdx = writeIdx - size;
        } else {
            readIdx = data.length + writeIdx - size;
        }

        T output = (T) data[readIdx];
        data[readIdx] = null;
        size--;
        return output;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
