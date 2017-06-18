package com.amdalal.github.algorithms.sort;

import com.amdalal.github.BaseTest;
import com.amdalal.github.algorithms.sort.impl.MergeSort;
import com.amdalal.github.ds.tree.MyInteger;
import org.junit.Assert;
import org.junit.Test;

public class TestMergeSort extends BaseTest {

    @Test
    public void test1() {
        MyInteger[] data = new MyInteger[3];
        data[0] = MyInteger.valueOf(3);
        data[1] = MyInteger.valueOf(2);
        data[2] = MyInteger.valueOf(1);
        Sort<MyInteger> mergeSort = new MergeSort<>();
        MyInteger[] output = mergeSort.sort(data, true);
        Assert.assertEquals(MyInteger.valueOf(1), output[0]);
        Assert.assertEquals(MyInteger.valueOf(2), output[1]);
        Assert.assertEquals(MyInteger.valueOf(3), output[2]);
    }

    @Test
    public void test2() {
        MyInteger[] data = new MyInteger[7];
        data[0] = MyInteger.valueOf(-1);
        data[1] = MyInteger.valueOf(3);
        data[2] = MyInteger.valueOf(5);
        data[3] = MyInteger.valueOf(1);
        data[4] = MyInteger.valueOf(0);
        data[5] = MyInteger.valueOf(-10);
        data[6] = MyInteger.valueOf(19);
        Sort<MyInteger> mergeSort = new MergeSort<>();
        MyInteger[] output = mergeSort.sort(data, true);
        Assert.assertEquals(MyInteger.valueOf(-10), output[0]);
        Assert.assertEquals(MyInteger.valueOf(-1), output[1]);
        Assert.assertEquals(MyInteger.valueOf(0), output[2]);
        Assert.assertEquals(MyInteger.valueOf(1), output[3]);
        Assert.assertEquals(MyInteger.valueOf(3), output[4]);
        Assert.assertEquals(MyInteger.valueOf(5), output[5]);
        Assert.assertEquals(MyInteger.valueOf(19), output[6]);

        output = mergeSort.sort(data, false);
        Assert.assertEquals(MyInteger.valueOf(-10), output[6]);
        Assert.assertEquals(MyInteger.valueOf(-1), output[5]);
        Assert.assertEquals(MyInteger.valueOf(0), output[4]);
        Assert.assertEquals(MyInteger.valueOf(1), output[3]);
        Assert.assertEquals(MyInteger.valueOf(3), output[2]);
        Assert.assertEquals(MyInteger.valueOf(5), output[1]);
        Assert.assertEquals(MyInteger.valueOf(19), output[0]);
    }
}
