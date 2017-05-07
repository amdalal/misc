package com.amdalal.github.ds.tree.bt.traversal;

import com.amdalal.github.ds.tree.MyInteger;
import com.amdalal.github.ds.tree.TreeHelper;
import org.junit.Assert;
import org.junit.Test;

public class TestLevelOrderTraversal {

    @Test
    public void test1() {
        MyInteger x = new MyInteger(1);
        x.clear();
        LevelOrderTraversal<MyInteger> levelOrderTraversal = new LevelOrderTraversal<>(TreeHelper.getTree());
        levelOrderTraversal.traverse();
        Assert.assertEquals("1-2-3-4-5-6-7-8-9-10-11-12", x.getOutput());
    }
}
