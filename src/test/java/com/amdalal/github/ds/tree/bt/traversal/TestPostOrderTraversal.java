package com.amdalal.github.ds.tree.bt.traversal;

import com.amdalal.github.ds.tree.MyInteger;
import com.amdalal.github.ds.tree.TreeHelper;
import org.junit.Assert;
import org.junit.Test;

public class TestPostOrderTraversal {

    @Test
    public void test1() {
        MyInteger x = new MyInteger(1);
        x.clear();
        PostOrderTraversal<MyInteger> traversal = new PostOrderTraversal<>(TreeHelper.getTree());
        traversal.traverse();
        Assert.assertEquals("4-8-9-5-2-6-10-12-11-7-3-1", x.getOutput());
    }
}
