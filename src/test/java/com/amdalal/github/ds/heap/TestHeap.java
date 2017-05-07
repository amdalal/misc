package com.amdalal.github.ds.heap;

import org.junit.Assert;
import org.junit.Test;

import com.amdalal.github.ds.tree.MyInteger;

public class TestHeap {

    @Test
    public void test1() {
        Heap<MyInteger> heap = new Heap<>(10, Heap.Type.MAX);
        heap.insert(MyInteger.valueOf(1));
        heap.insert(MyInteger.valueOf(2));
        heap.insert(MyInteger.valueOf(100));
        heap.insert(MyInteger.valueOf(7));
        heap.insert(MyInteger.valueOf(4));
        heap.insert(MyInteger.valueOf(10));
        heap.insert(MyInteger.valueOf(11));
        heap.insert(MyInteger.valueOf(0));
        heap.insert(MyInteger.valueOf(12));
        heap.insert(MyInteger.valueOf(9));
        Assert.assertEquals(10, heap.getSize());
        Assert.assertEquals(MyInteger.valueOf(100), heap.getRoot());
        Assert.assertEquals(10, heap.getCapacity());

        Assert.assertEquals(MyInteger.valueOf(100), heap.extractRoot());
        Assert.assertEquals(MyInteger.valueOf(12), heap.extractRoot());
        Assert.assertEquals(MyInteger.valueOf(11), heap.extractRoot());
        Assert.assertEquals(MyInteger.valueOf(10), heap.extractRoot());
        Assert.assertEquals(6, heap.getSize());
        Assert.assertEquals(MyInteger.valueOf(9), heap.extractRoot());
        Assert.assertEquals(MyInteger.valueOf(7), heap.extractRoot());
        Assert.assertEquals(MyInteger.valueOf(4), heap.extractRoot());
        Assert.assertEquals(MyInteger.valueOf(2), heap.extractRoot());
        Assert.assertEquals(MyInteger.valueOf(1), heap.extractRoot());
        Assert.assertEquals(MyInteger.valueOf(0), heap.extractRoot());
    }

    @Test
    public void test2() {
        Heap<MyInteger> heap = new Heap<>(11, Heap.Type.MIN);
        heap.insert(MyInteger.valueOf(10));
        heap.insert(MyInteger.valueOf(12));
        heap.insert(MyInteger.valueOf(11));
        heap.insert(MyInteger.valueOf(43));
        heap.insert(MyInteger.valueOf(65));
        heap.insert(MyInteger.valueOf(76));
        heap.insert(MyInteger.valueOf(32));
        heap.insert(MyInteger.valueOf(86));
        heap.insert(MyInteger.valueOf(23));
        heap.insert(MyInteger.valueOf(10));
        heap.insert(MyInteger.valueOf(90));
        Assert.assertEquals(11, heap.getSize());
        Assert.assertEquals(MyInteger.valueOf(10), heap.getRoot());
        Assert.assertEquals(11, heap.getCapacity());

        Assert.assertEquals(MyInteger.valueOf(10), heap.extractRoot());
        Assert.assertEquals(MyInteger.valueOf(10), heap.extractRoot());
        Assert.assertEquals(MyInteger.valueOf(11), heap.extractRoot());
        Assert.assertEquals(8, heap.getSize());
        Assert.assertEquals(MyInteger.valueOf(12), heap.extractRoot());
        Assert.assertEquals(MyInteger.valueOf(23), heap.extractRoot());
        Assert.assertEquals(MyInteger.valueOf(32), heap.extractRoot());
        Assert.assertEquals(MyInteger.valueOf(43), heap.extractRoot());
        Assert.assertEquals(MyInteger.valueOf(65), heap.extractRoot());
        Assert.assertEquals(MyInteger.valueOf(76), heap.extractRoot());
        Assert.assertEquals(2, heap.getSize());
        Assert.assertEquals(MyInteger.valueOf(86), heap.extractRoot());
        Assert.assertEquals(MyInteger.valueOf(90), heap.extractRoot());
    }

    @Test
    public void test3() {
        Heap<MyInteger> heap = new Heap<>(2, Heap.Type.MAX);
        heap.insert(MyInteger.valueOf(10));
        heap.insert(MyInteger.valueOf(12));
        Assert.assertEquals(-1, heap.insert(MyInteger.valueOf(11)));
    }

    @Test
    public void test4() {
        MyInteger[] array = new MyInteger[10];
        array[0] = MyInteger.valueOf(10);
        array[1] = MyInteger.valueOf(12);
        array[2] = MyInteger.valueOf(11);
        array[3] = MyInteger.valueOf(43);
        array[4] = MyInteger.valueOf(65);
        array[5] = MyInteger.valueOf(76);
        array[6] = MyInteger.valueOf(32);
        array[7] = MyInteger.valueOf(86);
        array[8] = MyInteger.valueOf(23);
        array[9] = MyInteger.valueOf(90);
        Heap<MyInteger> heap = new Heap<>(array, Heap.Type.MIN);

        Assert.assertEquals(10, heap.getSize());
        Assert.assertEquals(MyInteger.valueOf(10), heap.getRoot());
        Assert.assertEquals(10, heap.getCapacity());

        Assert.assertEquals(MyInteger.valueOf(10), heap.extractRoot());
        Assert.assertEquals(MyInteger.valueOf(11), heap.extractRoot());
        Assert.assertEquals(8, heap.getSize());
        Assert.assertEquals(MyInteger.valueOf(12), heap.extractRoot());
        Assert.assertEquals(MyInteger.valueOf(23), heap.extractRoot());
        Assert.assertEquals(MyInteger.valueOf(32), heap.extractRoot());
        Assert.assertEquals(MyInteger.valueOf(43), heap.extractRoot());
        Assert.assertEquals(MyInteger.valueOf(65), heap.extractRoot());
        Assert.assertEquals(MyInteger.valueOf(76), heap.extractRoot());
        Assert.assertEquals(2, heap.getSize());
        Assert.assertEquals(MyInteger.valueOf(86), heap.extractRoot());
        Assert.assertEquals(MyInteger.valueOf(90), heap.extractRoot());
    }
}
