package com.amdalal.github.ds.heap;

import com.amdalal.github.ds.tree.MyInteger;
import org.junit.Assert;
import org.junit.Test;

public class TestHeap {

    @Test
    public void test1() {
        Heap<MyInteger> heap = new Heap<>(10, Heap.Type.MAX);
        heap.insert(new MyInteger(1));
        heap.insert(new MyInteger(2));
        heap.insert(new MyInteger(100));
        heap.insert(new MyInteger(7));
        heap.insert(new MyInteger(4));
        heap.insert(new MyInteger(10));
        heap.insert(new MyInteger(11));
        heap.insert(new MyInteger(0));
        heap.insert(new MyInteger(12));
        heap.insert(new MyInteger(9));
        Assert.assertEquals(10, heap.getSize());
        Assert.assertEquals(new MyInteger(100), heap.getRoot());
        Assert.assertEquals(10, heap.getCapacity());

        Assert.assertEquals(new MyInteger(100), heap.extractRoot());
        Assert.assertEquals(new MyInteger(12), heap.extractRoot());
        Assert.assertEquals(new MyInteger(11), heap.extractRoot());
        Assert.assertEquals(new MyInteger(10), heap.extractRoot());
        Assert.assertEquals(6, heap.getSize());
        Assert.assertEquals(new MyInteger(9), heap.extractRoot());
        Assert.assertEquals(new MyInteger(7), heap.extractRoot());
        Assert.assertEquals(new MyInteger(4), heap.extractRoot());
        Assert.assertEquals(new MyInteger(2), heap.extractRoot());
        Assert.assertEquals(new MyInteger(1), heap.extractRoot());
        Assert.assertEquals(new MyInteger(0), heap.extractRoot());
    }

    @Test
    public void test2() {
        Heap<MyInteger> heap = new Heap<>(11, Heap.Type.MIN);
        heap.insert(new MyInteger(10));
        heap.insert(new MyInteger(12));
        heap.insert(new MyInteger(11));
        heap.insert(new MyInteger(43));
        heap.insert(new MyInteger(65));
        heap.insert(new MyInteger(76));
        heap.insert(new MyInteger(32));
        heap.insert(new MyInteger(86));
        heap.insert(new MyInteger(23));
        heap.insert(new MyInteger(10));
        heap.insert(new MyInteger(90));
        Assert.assertEquals(11, heap.getSize());
        Assert.assertEquals(new MyInteger(10), heap.getRoot());
        Assert.assertEquals(11, heap.getCapacity());

        Assert.assertEquals(new MyInteger(10), heap.extractRoot());
        Assert.assertEquals(new MyInteger(10), heap.extractRoot());
        Assert.assertEquals(new MyInteger(11), heap.extractRoot());
        Assert.assertEquals(8, heap.getSize());
        Assert.assertEquals(new MyInteger(12), heap.extractRoot());
        Assert.assertEquals(new MyInteger(23), heap.extractRoot());
        Assert.assertEquals(new MyInteger(32), heap.extractRoot());
        Assert.assertEquals(new MyInteger(43), heap.extractRoot());
        Assert.assertEquals(new MyInteger(65), heap.extractRoot());
        Assert.assertEquals(new MyInteger(76), heap.extractRoot());
        Assert.assertEquals(2, heap.getSize());
        Assert.assertEquals(new MyInteger(86), heap.extractRoot());
        Assert.assertEquals(new MyInteger(90), heap.extractRoot());
    }

    @Test
    public void test3() {
        Heap<MyInteger> heap = new Heap<>(2, Heap.Type.MAX);
        heap.insert(new MyInteger(10));
        heap.insert(new MyInteger(12));
        Assert.assertEquals(-1, heap.insert(new MyInteger(11)));
    }

    @Test
    public void test4() {
        MyInteger[] array = new MyInteger[10];
        array[0] = new MyInteger(10);
        array[1] = new MyInteger(12);
        array[2] = new MyInteger(11);
        array[3] = new MyInteger(43);
        array[4] = new MyInteger(65);
        array[5] = new MyInteger(76);
        array[6] = new MyInteger(32);
        array[7] = new MyInteger(86);
        array[8] = new MyInteger(23);
        array[9] = new MyInteger(90);
        Heap<MyInteger> heap = new Heap<>(array, Heap.Type.MIN);

        Assert.assertEquals(10, heap.getSize());
        Assert.assertEquals(new MyInteger(10), heap.getRoot());
        Assert.assertEquals(10, heap.getCapacity());

        Assert.assertEquals(new MyInteger(10), heap.extractRoot());
        Assert.assertEquals(new MyInteger(11), heap.extractRoot());
        Assert.assertEquals(8, heap.getSize());
        Assert.assertEquals(new MyInteger(12), heap.extractRoot());
        Assert.assertEquals(new MyInteger(23), heap.extractRoot());
        Assert.assertEquals(new MyInteger(32), heap.extractRoot());
        Assert.assertEquals(new MyInteger(43), heap.extractRoot());
        Assert.assertEquals(new MyInteger(65), heap.extractRoot());
        Assert.assertEquals(new MyInteger(76), heap.extractRoot());
        Assert.assertEquals(2, heap.getSize());
        Assert.assertEquals(new MyInteger(86), heap.extractRoot());
        Assert.assertEquals(new MyInteger(90), heap.extractRoot());
    }
}
