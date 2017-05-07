package com.amdalal.github.ds.tree.bt.traversal;

import com.amdalal.github.ResultHolder;
import org.junit.Assert;
import org.junit.Test;

import com.amdalal.github.ds.tree.MyInteger;
import com.amdalal.github.ds.tree.TreeHelper;

public class TestLevelOrderTraversal {

    @Test
    public void test1() {
        new LevelOrderTraversal<>(TreeHelper.getTree()).traverse();
        Assert.assertEquals("1-2-3-4-5-6-7-8-9-10-11-12", ResultHolder.getResult());
    }
}
