package com.amdalal.github.ds.tree.bt;

import com.amdalal.github.ds.tree.MyInteger;
import org.junit.Test;

public class TestBinaryTree {

    @Test(expected = NullPointerException.class)
    public void test1() {
        BinaryTree<MyInteger> t = new BinaryTree<>();
        t.setRoot(null);
    }
}
