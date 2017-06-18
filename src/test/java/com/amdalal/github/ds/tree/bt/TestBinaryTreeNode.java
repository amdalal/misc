package com.amdalal.github.ds.tree.bt;

import com.amdalal.github.BaseTest;
import org.junit.Test;

import com.amdalal.github.ds.tree.MyInteger;

public class TestBinaryTreeNode extends BaseTest {

    @Test(expected = IllegalArgumentException.class)
    public void test2() {
        BinaryTreeNode<MyInteger> n1 = new BinaryTreeNode<>(MyInteger.valueOf(1));
        n1.addLeftChild(new BinaryTreeNode<>(MyInteger.valueOf(2)));
        n1.addLeftChild(new BinaryTreeNode<>(MyInteger.valueOf(3)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test3() {
        BinaryTreeNode<MyInteger> n1 = new BinaryTreeNode<>(MyInteger.valueOf(1));
        n1.addRightChild(new BinaryTreeNode<>(MyInteger.valueOf(2)));
        n1.addRightChild(new BinaryTreeNode<>(MyInteger.valueOf(3)));
    }
}
