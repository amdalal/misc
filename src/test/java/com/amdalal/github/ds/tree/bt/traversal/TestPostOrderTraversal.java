package com.amdalal.github.ds.tree.bt.traversal;

import com.amdalal.github.ResultHolder;
import org.junit.Assert;
import org.junit.Test;

import com.amdalal.github.ds.tree.MyInteger;
import com.amdalal.github.ds.tree.TreeHelper;

public class TestPostOrderTraversal {

    @Test
    public void test1() {
        new PostOrderTraversal<>(TreeHelper.getTree()).traverse();
        Assert.assertEquals("4-8-9-5-2-6-10-12-11-7-3-1", ResultHolder.getResult());
    }
}
