package com.amdalal.github.ds.tree.bt;

import com.amdalal.github.ds.tree.MyInteger;
import org.junit.Test;

public class TestBinaryTreeNode {

    @Test(expected = IllegalArgumentException.class)
    public void test2() {
        BinaryTreeNode<MyInteger> n1 = new BinaryTreeNode<>(new MyInteger(1));
        n1.addLeftChild(new BinaryTreeNode<>(new MyInteger(2)));
        n1.addLeftChild(new BinaryTreeNode<>(new MyInteger(3)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test3() {
        BinaryTreeNode<MyInteger> n1 = new BinaryTreeNode<>(new MyInteger(1));
        n1.addRightChild(new BinaryTreeNode<>(new MyInteger(2)));
        n1.addRightChild(new BinaryTreeNode<>(new MyInteger(3)));
    }
}
