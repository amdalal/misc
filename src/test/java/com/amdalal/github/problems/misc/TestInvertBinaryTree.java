package com.amdalal.github.problems.misc;

import com.amdalal.github.BaseTest;
import org.junit.Assert;
import org.junit.Test;

import com.amdalal.github.ResultHolder;
import com.amdalal.github.ds.tree.MyInteger;
import com.amdalal.github.ds.tree.Traversal;
import com.amdalal.github.ds.tree.bt.BinaryTree;
import com.amdalal.github.ds.tree.bt.BinaryTreeNode;
import com.amdalal.github.ds.tree.bt.traversal.InOrderTraversal;

public class TestInvertBinaryTree extends BaseTest {

    @Test
    public void test1() {
        BinaryTreeNode<MyInteger> n1 = new BinaryTreeNode<>(MyInteger.valueOf(1));
        BinaryTreeNode<MyInteger> n2 = new BinaryTreeNode<>(MyInteger.valueOf(2));
        BinaryTreeNode<MyInteger> n3 = new BinaryTreeNode<>(MyInteger.valueOf(3));
        BinaryTreeNode<MyInteger> n4 = new BinaryTreeNode<>(MyInteger.valueOf(4));
        BinaryTreeNode<MyInteger> n5 = new BinaryTreeNode<>(MyInteger.valueOf(5));
        BinaryTreeNode<MyInteger> n6 = new BinaryTreeNode<>(MyInteger.valueOf(6));
        BinaryTreeNode<MyInteger> n7 = new BinaryTreeNode<>(MyInteger.valueOf(7));
        BinaryTreeNode<MyInteger> n8 = new BinaryTreeNode<>(MyInteger.valueOf(8));
        BinaryTreeNode<MyInteger> n9 = new BinaryTreeNode<>(MyInteger.valueOf(9));
        BinaryTreeNode<MyInteger> n10 = new BinaryTreeNode<>(MyInteger.valueOf(10));
        BinaryTreeNode<MyInteger> n11 = new BinaryTreeNode<>(MyInteger.valueOf(11));
        BinaryTreeNode<MyInteger> n12 = new BinaryTreeNode<>(MyInteger.valueOf(12));
        BinaryTreeNode<MyInteger> n13 = new BinaryTreeNode<>(MyInteger.valueOf(13));

        n4.setLeftChild(n3);
        n4.setRightChild(n2);

        n3.setLeftChild(n1);
        n3.setRightChild(n5);

        n1.setLeftChild(n8);
        n1.setRightChild(n9);

        n5.setLeftChild(n10);
        n5.setRightChild(n11);

        n2.setLeftChild(n6);
        n2.setRightChild(n7);

        n7.setLeftChild(n13);
        n7.setRightChild(n12);
        BinaryTree<MyInteger> tree = new BinaryTree<>();
        tree.setRoot(n4);

        BinaryTree<MyInteger> invertedTree = new InvertBinaryTree<MyInteger>().invert(tree);
        Traversal<MyInteger> traversal = new InOrderTraversal<>(invertedTree);
        traversal.traverse();
        Assert.assertEquals("12-7-13-2-6-4-11-5-10-3-9-1-8", ResultHolder.getResult());
    }
}
