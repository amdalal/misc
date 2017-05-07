package com.amdalal.github.problems.binaryserch;

public class BinarySearch<T extends Comparable<T>> {

    public boolean find(final T[] data, final T key) {
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("invalid input");
        }
        if (key == null) {
            throw new IllegalArgumentException("key cannot be null");
        }
        return find(0, data.length - 1, data, key);
    }

    private boolean find(int startIndex, int endIndex, T[] data, T key) {
        int midIndex = (startIndex + endIndex) / 2;
        T dataAtMidIndex = data[midIndex];
        if (dataAtMidIndex.equals(key)) {
            return true;
        }
        if (startIndex >= endIndex) {
            return false;
        }
        if (dataAtMidIndex.compareTo(key) < 0) {
            return find(midIndex + 1, endIndex, data, key);
        } else {
            return find(startIndex, midIndex - 1, data, key);
        }
    }
}

