package com.amdalal.github.algorithms.sort.impl;

import com.amdalal.github.algorithms.sort.Sort;
import com.amdalal.github.ds.heap.Heap;

import java.lang.reflect.Array;

public class HeapSort<T extends Comparable<? super T>> implements Sort<T> {

    @Override
    public T[] sort(T[] data, boolean ascending) {
        Heap<T> heap = new Heap<>(data, ascending ? Heap.Type.MIN : Heap.Type.MAX);

        T[] output = (T[]) Array.newInstance(data[0].getClass(), data.length);
        for (int i = 0; i < data.length; i++) {
            output[i] = heap.extractRoot();
        }
        return output;
    }
}
