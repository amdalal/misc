package com.amdalal.github.problems.misc;

import java.util.Stack;

import com.amdalal.github.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class TestSortedStack extends BaseTest {

    @Test
    public void test1() {
        Stack<Integer> stack = new Stack<>();
        stack.push(9);
        stack.push(8);
        stack.push(7);
        stack.push(6);
        stack.push(5);
        stack = SortStack.sort(stack);
        Assert.assertTrue(stack.pop().equals(5));
        Assert.assertTrue(stack.pop().equals(6));
        Assert.assertTrue(stack.pop().equals(7));
        Assert.assertTrue(stack.pop().equals(8));
        Assert.assertTrue(stack.pop().equals(9));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test2() {
        SortStack.sort(null);
    }
}
