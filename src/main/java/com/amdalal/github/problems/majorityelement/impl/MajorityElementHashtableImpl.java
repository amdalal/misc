package com.amdalal.github.problems.majorityelement.impl;

import com.amdalal.github.problems.majorityelement.MajorityElement;

public class MajorityElementHashtableImpl implements MajorityElement {

    @Override
    public Integer getMajorityElement(final int[] data) {
        java.util.Hashtable<Integer, Integer> register = new java.util.Hashtable<>();
        for (int i : data) {
            Integer currentCount = register.get(i);
            if (currentCount == null) {
                currentCount = 0;
            }
            register.put(i, ++currentCount);
            if (currentCount > (data.length) / 2) {
                return i;
            }
        }
        return null;
    }
}