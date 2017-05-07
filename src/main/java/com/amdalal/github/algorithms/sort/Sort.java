package com.amdalal.github.algorithms.sort;

public interface Sort<T extends Comparable<? super T>> {

    T[] sort(T[] data, boolean ascending);

}
