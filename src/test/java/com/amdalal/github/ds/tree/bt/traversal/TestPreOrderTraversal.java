package com.amdalal.github.ds.tree.bt.traversal;

import com.amdalal.github.ds.tree.MyInteger;
import com.amdalal.github.ds.tree.bt.BinaryTree;
import com.amdalal.github.ds.tree.TreeHelper;
import com.amdalal.github.ds.tree.bt.BinaryTreeNode;
import org.junit.Assert;
import org.junit.Test;

public class TestPreOrderTraversal {

    @Test
    public void test1() {
        PreOrderTraversal<MyInteger> traversal = new PreOrderTraversal<>(TreeHelper.getTree());
        Assert.assertEquals(MyInteger.valueOf(1), traversal.next());
        Assert.assertEquals(MyInteger.valueOf(2), traversal.next());
        Assert.assertEquals(MyInteger.valueOf(4), traversal.next());
        Assert.assertEquals(MyInteger.valueOf(5), traversal.next());
        Assert.assertEquals(MyInteger.valueOf(8), traversal.next());
        Assert.assertEquals(MyInteger.valueOf(9), traversal.next());
        Assert.assertEquals(MyInteger.valueOf(3), traversal.next());
        Assert.assertEquals(MyInteger.valueOf(6), traversal.next());
        Assert.assertEquals(MyInteger.valueOf(7), traversal.next());
        Assert.assertEquals(MyInteger.valueOf(10), traversal.next());
        Assert.assertEquals(MyInteger.valueOf(11), traversal.next());
        Assert.assertEquals(MyInteger.valueOf(12), traversal.next());
        Assert.assertEquals(null, traversal.next());
        traversal.traverse();
    }

    @Test
    public void test2() {
        BinaryTree<MyInteger> t = new BinaryTree<>();
        BinaryTreeNode<MyInteger> n1 = new BinaryTreeNode<>(new MyInteger(1));
        t.setRoot(n1);

        PreOrderTraversal<MyInteger> traversal = new PreOrderTraversal<>(t);
        Assert.assertEquals(MyInteger.valueOf(1), traversal.next());
        Assert.assertEquals(null, traversal.next());
    }

}
