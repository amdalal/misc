package com.amdalal.github.ds.graph;

import org.junit.Assert;
import org.junit.Test;

import com.amdalal.github.ResultHolder;

public class TestDFS {

    @Test
    public void test1() {
        ResultHolder.clear();
        GraphHelper.getGraph().dfs();
        Assert.assertEquals("1-2-6-3-4-5-7", ResultHolder.getResult());
    }
}
