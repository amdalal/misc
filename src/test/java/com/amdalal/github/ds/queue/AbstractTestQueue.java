package com.amdalal.github.ds.queue;

import junit.framework.Assert;
import org.junit.Test;

public abstract class AbstractTestQueue {

    @Test
    public static void test1(Queue<Integer> queue) {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        Assert.assertEquals(Integer.valueOf(1), queue.dequeue());
        queue.enqueue(6);
        Assert.assertEquals(false, queue.isEmpty());
        Assert.assertEquals(Integer.valueOf(2), queue.dequeue());
        Assert.assertEquals(Integer.valueOf(3), queue.dequeue());
        Assert.assertEquals(Integer.valueOf(4), queue.dequeue());
        Assert.assertEquals(Integer.valueOf(5), queue.dequeue());

        queue.enqueue(7);
        queue.enqueue(8);

        Assert.assertEquals(Integer.valueOf(6), queue.dequeue());
        Assert.assertEquals(Integer.valueOf(7), queue.dequeue());
        Assert.assertEquals(Integer.valueOf(8), queue.dequeue());
        Assert.assertEquals(true, queue.isEmpty());
    }
}
