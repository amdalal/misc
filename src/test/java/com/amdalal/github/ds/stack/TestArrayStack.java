package com.amdalal.github.ds.stack;

import com.amdalal.github.ds.stack.impl.ArrayStack;
import org.junit.Assert;
import org.junit.Test;

public class TestArrayStack {

    @Test
    public void test1() {
        Stack<Integer> stack = new ArrayStack<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        Assert.assertEquals(Integer.valueOf(5), stack.pop());
        Assert.assertEquals(Integer.valueOf(4), stack.pop());
        Assert.assertEquals(Integer.valueOf(3), stack.pop());

        Assert.assertFalse(stack.isEmpty());
        Assert.assertEquals(2, stack.size());

        Assert.assertEquals(Integer.valueOf(2), stack.pop());
        Assert.assertEquals(Integer.valueOf(1), stack.pop());

        Assert.assertTrue(stack.isEmpty());
        Assert.assertEquals(0, stack.size());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void test2() {
        Stack<Integer> stack = new ArrayStack<>(1);
        stack.push(1);
        stack.push(2);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void test3() {
        Stack<Integer> stack = new ArrayStack<>(1);
        stack.push(1);
        stack.pop();
        stack.pop();
    }
}
