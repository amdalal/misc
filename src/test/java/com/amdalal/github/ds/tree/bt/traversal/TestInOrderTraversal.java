package com.amdalal.github.ds.tree.bt.traversal;

import com.amdalal.github.ResultHolder;
import org.junit.Assert;
import org.junit.Test;

import com.amdalal.github.ds.tree.MyInteger;
import com.amdalal.github.ds.tree.TreeHelper;

public class TestInOrderTraversal {

    @Test
    public void test1() {
        ResultHolder.clear();
        new InOrderTraversal<>(TreeHelper.getTree()).traverse();
        Assert.assertEquals("4-2-8-5-9-1-6-3-10-7-11-12", ResultHolder.getResult());
    }
}
