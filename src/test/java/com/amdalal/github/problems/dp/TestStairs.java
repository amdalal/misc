package com.amdalal.github.problems.dp;

import org.junit.Assert;
import org.junit.Test;

import com.amdalal.github.BaseTest;

public class TestStairs extends BaseTest {

    @Test
    public void test1() {
        Assert.assertEquals(0, Stairs.numberOfWays(0));
        Assert.assertEquals(1, Stairs.numberOfWays(1));
        Assert.assertEquals(2, Stairs.numberOfWays(2));
        Assert.assertEquals(4, Stairs.numberOfWays(3));
        Assert.assertEquals(7, Stairs.numberOfWays(4));
        Assert.assertEquals(13, Stairs.numberOfWays(5));
    }
}
