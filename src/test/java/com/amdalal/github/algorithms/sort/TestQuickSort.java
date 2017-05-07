package com.amdalal.github.algorithms.sort;

import com.amdalal.github.algorithms.sort.impl.QuickSort;
import com.amdalal.github.ds.tree.MyInteger;
import org.junit.Assert;
import org.junit.Test;

public class TestQuickSort {

    @Test
    public void test1() {
        MyInteger[] data = new MyInteger[3];
        data[0] = new MyInteger(3);
        data[1] = new MyInteger(2);
        data[2] = new MyInteger(1);
        Sort<MyInteger> sorter = new QuickSort<>();
        MyInteger[] output = sorter.sort(data, true);
        Assert.assertEquals(new MyInteger(1), output[0]);
        Assert.assertEquals(new MyInteger(2), output[1]);
        Assert.assertEquals(new MyInteger(3), output[2]);
    }

    @Test
    public void test2() {
        MyInteger[] data = new MyInteger[7];
        data[0] = new MyInteger(-1);
        data[1] = new MyInteger(3);
        data[2] = new MyInteger(5);
        data[3] = new MyInteger(1);
        data[4] = new MyInteger(0);
        data[5] = new MyInteger(-10);
        data[6] = new MyInteger(19);
        Sort<MyInteger> sorter = new QuickSort<>();
        MyInteger[] output = sorter.sort(data, true);
        Assert.assertEquals(new MyInteger(-10), output[0]);
        Assert.assertEquals(new MyInteger(-1), output[1]);
        Assert.assertEquals(new MyInteger(0), output[2]);
        Assert.assertEquals(new MyInteger(1), output[3]);
        Assert.assertEquals(new MyInteger(3), output[4]);
        Assert.assertEquals(new MyInteger(5), output[5]);
        Assert.assertEquals(new MyInteger(19), output[6]);

        output = sorter.sort(data, false);
        Assert.assertEquals(new MyInteger(-10), output[6]);
        Assert.assertEquals(new MyInteger(-1), output[5]);
        Assert.assertEquals(new MyInteger(0), output[4]);
        Assert.assertEquals(new MyInteger(1), output[3]);
        Assert.assertEquals(new MyInteger(3), output[2]);
        Assert.assertEquals(new MyInteger(5), output[1]);
        Assert.assertEquals(new MyInteger(19), output[0]);
    }
}
