package com.amdalal.github.ds.tree.bt.traversal;

import org.junit.Assert;
import org.junit.Test;

import com.amdalal.github.BaseTest;
import com.amdalal.github.ResultHolder;
import com.amdalal.github.ds.tree.TreeHelper;

public class TestLevelOrderTraversal extends BaseTest {

    @Test
    public void test1() {
        new LevelOrderTraversal<>(TreeHelper.getTree()).traverse();
        Assert.assertEquals("1-2-3-4-5-6-7-8-9-10-11-12", ResultHolder.getResult());
    }
}
