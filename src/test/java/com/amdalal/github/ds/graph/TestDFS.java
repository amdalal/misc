package com.amdalal.github.ds.graph;

import com.amdalal.github.BaseTest;
import org.junit.Assert;
import org.junit.Test;

import com.amdalal.github.ResultHolder;

public class TestDFS extends BaseTest {

    @Test
    public void test1() {
        GraphHelper.getGraph().dfs();
        Assert.assertEquals("1-2-6-3-4-5-7", ResultHolder.getResult());
    }
}
