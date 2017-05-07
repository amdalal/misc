package com.amdalal.github.ds.queue;

public interface Queue<T> {

    T enqueue(T element);

    T dequeue();

    boolean isEmpty();

}
