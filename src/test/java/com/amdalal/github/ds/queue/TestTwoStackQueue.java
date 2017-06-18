package com.amdalal.github.ds.queue;

import com.amdalal.github.BaseTest;
import com.amdalal.github.ds.queue.impl.TwoStackQueue;
import org.junit.Test;

public class TestTwoStackQueue extends BaseTest {

    @Test
    public void test1() {
        AbstractTestQueue.test1(new TwoStackQueue<>(5));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void test2() {
        Queue<Integer> queue = new TwoStackQueue<>(2);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void test3() {
        Queue<Integer> queue = new TwoStackQueue<>(2);
        queue.dequeue();
    }
}
