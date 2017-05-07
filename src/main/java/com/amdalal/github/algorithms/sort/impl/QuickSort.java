package com.amdalal.github.algorithms.sort.impl;

import com.amdalal.github.algorithms.sort.Sort;

public class QuickSort<T extends Comparable<? super T>> implements Sort<T> {

    @Override
    public T[] sort(T[] data, boolean ascending) {
        for (int i = 0; i < data.length; i++) {
            doSort(data, i, ascending);
        }
        return data;
    }

    private void doSort(T[] data, int pivot, boolean ascending) {
        int low = 0;
        int hi = data.length - 1;
        while (low < hi) {
            if (pivot > low) {
                if ((ascending && data[pivot].compareTo(data[low]) < 0) || (!ascending && data[pivot].compareTo(data[low]) > 0)) {
                    swap(data, pivot, low);
                    pivot = low;
                } else {
                    low++;
                }
            }
            if (pivot < hi) {
                if ((ascending && data[pivot].compareTo(data[hi]) > 0) || (!ascending && data[pivot].compareTo(data[hi]) < 0)) {
                    swap(data, pivot, hi);
                    pivot = hi;
                } else {
                    hi--;
                }
            }
        }
    }

    private void swap(T[] data, int fromIdx, int toIdx) {
        T temp = data[fromIdx];
        data[fromIdx] = data[toIdx];
        data[toIdx] = temp;
    }
}
