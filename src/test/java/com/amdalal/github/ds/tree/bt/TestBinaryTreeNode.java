package com.amdalal.github.ds.tree.bt;

import org.junit.Test;

import com.amdalal.github.ds.tree.MyInteger;

public class TestBinaryTreeNode {

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
