package com.amdalal.github.ds.queue;

import com.amdalal.github.BaseTest;
import com.amdalal.github.ds.queue.impl.RingBufferQueue;
import org.junit.Test;

public class TestRingBufferQueue extends BaseTest {

    @Test
    public void test1() {
        AbstractTestQueue.test1(new RingBufferQueue<>(5));
    }

    @Test(expected = IllegalStateException.class)
    public void test2() {
        Queue<Integer> ringBufferQueue = new RingBufferQueue<>(2);
        ringBufferQueue.enqueue(1);
        ringBufferQueue.enqueue(2);
        ringBufferQueue.enqueue(3);
    }

    @Test(expected = IllegalStateException.class)
    public void test3() {
        Queue<Integer> ringBufferQueue = new RingBufferQueue<>(2);
        ringBufferQueue.dequeue();
    }
}
