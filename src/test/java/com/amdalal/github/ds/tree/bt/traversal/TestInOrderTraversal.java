package com.amdalal.github.ds.tree.bt.traversal;

import com.amdalal.github.ds.tree.MyInteger;
import com.amdalal.github.ds.tree.TreeHelper;
import org.junit.Assert;
import org.junit.Test;

public class TestInOrderTraversal {

    @Test
    public void test1() {
        MyInteger x = new MyInteger(1);
        x.clear();
        InOrderTraversal<MyInteger> traversal = new InOrderTraversal<>(TreeHelper.getTree());
        traversal.traverse();
        Assert.assertEquals("4-2-8-5-9-1-6-3-10-7-11-12", x.getOutput());
    }
}
