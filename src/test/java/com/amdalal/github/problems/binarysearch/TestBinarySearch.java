package com.amdalal.github.problems.binarysearch;

import com.amdalal.github.problems.binaryserch.BinarySearch;
import org.junit.Assert;
import org.junit.Test;

public class TestBinarySearch {

    @Test
    public void test1() {
        BinarySearch<Integer> bs = new BinarySearch<>();
        Integer[] data = { 1, 2, 3, 4, 5 };
        Assert.assertTrue(bs.find(data, 1));
        Assert.assertTrue(bs.find(data, 4));
        Assert.assertTrue(bs.find(data, 5));
        Assert.assertFalse(bs.find(data, -1));
        Assert.assertFalse(bs.find(data, 6));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test2() {
        BinarySearch<Integer> bs = new BinarySearch<>();
        Assert.assertTrue(bs.find(null, 1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test3() {
        BinarySearch<Integer> bs = new BinarySearch<>();
        Assert.assertTrue(bs.find(new Integer[0], 1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test4() {
        BinarySearch<Integer> bs = new BinarySearch<>();
        Integer[] data = { 1, 2, 3, 4, 5 };
        Assert.assertTrue(bs.find(data, null));
    }
}
