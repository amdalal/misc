package com.amdalal.github.algorithms.sort.impl;

import com.amdalal.github.algorithms.sort.Sort;

public class MergeSort<T extends Comparable<? super T>> implements Sort<T> {

    @Override
    public T[] sort(T[] data, boolean ascending) {
        return sort(data, 0, data.length - 1, ascending);
    }

    private <T extends Comparable<? super T>> T[] sort(T[] data, int startIdx, int endIdx, boolean ascending) {
        int midIdx = (startIdx + endIdx) / 2;
        if (endIdx - startIdx > 1) {
            sort(data, startIdx, midIdx, ascending);
            sort(data, midIdx + 1, endIdx, ascending);
        }
        return merge(data, startIdx, midIdx, endIdx, ascending);
    }

    private <T extends Comparable<? super T>> T[] merge(T[] data, final int startIdx, final int midIdx, final int endIdx, final boolean ascending) {
        int mergedIdx = startIdx;
        int firstArrIdx = 0;
        int secondArrIdx = midIdx - startIdx + 1;
        Object[] temp = new Object[endIdx - startIdx + 1];
        for (int i = 0; i <= endIdx - startIdx; i++) {
            temp[i] = data[startIdx + i];
        }

        for (int i = 0; i < temp.length; i++) {
            if (secondArrIdx >= temp.length) {
                data[mergedIdx++] = (T) temp[firstArrIdx++];
            } else if (firstArrIdx > midIdx - startIdx) {
                data[mergedIdx++] = (T) temp[secondArrIdx++];
            } else {
                int comparisionResult = ((T) temp[firstArrIdx]).compareTo((T) temp[secondArrIdx]);
                if ((ascending && comparisionResult >= 0) || (!ascending && comparisionResult <= 0)) {
                    data[mergedIdx++] = (T) temp[secondArrIdx++];
                } else {
                    data[mergedIdx++] = (T) temp[firstArrIdx++];
                }
            }
        }
        return data;
    }
}
