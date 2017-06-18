package com.amdalal.github.ds.tree.bt.bst;

import com.amdalal.github.BaseTest;
import org.junit.Test;

import com.amdalal.github.ResultHolder;
import com.amdalal.github.ds.tree.MyInteger;
import com.amdalal.github.ds.tree.TreeHelper;
import com.amdalal.github.ds.tree.bt.traversal.LevelOrderTraversal;

import junit.framework.Assert;

public class TestBinarySearchTree extends BaseTest {

    @Test
    public void test1() {
        BinarySearchTree<MyInteger> tree = TreeHelper.getBinarySearchTree();
        Assert.assertTrue(tree.search(MyInteger.valueOf(1)));
        Assert.assertTrue(tree.search(MyInteger.valueOf(2)));
        Assert.assertTrue(tree.search(MyInteger.valueOf(3)));
        Assert.assertTrue(tree.search(MyInteger.valueOf(4)));
        Assert.assertTrue(tree.search(MyInteger.valueOf(5)));
        Assert.assertTrue(tree.search(MyInteger.valueOf(6)));
        Assert.assertTrue(tree.search(MyInteger.valueOf(7)));
        Assert.assertTrue(tree.search(MyInteger.valueOf(8)));
        Assert.assertTrue(tree.search(MyInteger.valueOf(9)));
        Assert.assertTrue(tree.search(MyInteger.valueOf(10)));
        Assert.assertTrue(tree.search(MyInteger.valueOf(11)));
        Assert.assertTrue(tree.search(MyInteger.valueOf(12)));
        Assert.assertFalse(tree.search(MyInteger.valueOf(13)));
        Assert.assertFalse(tree.search(MyInteger.valueOf(0)));
        Assert.assertFalse(tree.search(MyInteger.valueOf(-1)));
    }

    @Test
    public void test2() {
        BinarySearchTree<MyInteger> tree = new BinarySearchTree<>();
        tree.insert(MyInteger.valueOf(30));
        tree.insert(MyInteger.valueOf(10));
        tree.insert(MyInteger.valueOf(20));
        tree.insert(MyInteger.valueOf(40));
        tree.insert(MyInteger.valueOf(35));
        tree.insert(MyInteger.valueOf(50));
        tree.insert(MyInteger.valueOf(15));
        Assert.assertFalse(tree.search(MyInteger.valueOf(0)));
        Assert.assertTrue(tree.search(MyInteger.valueOf(10)));
        Assert.assertTrue(tree.search(MyInteger.valueOf(15)));
        Assert.assertTrue(tree.search(MyInteger.valueOf(20)));
        Assert.assertTrue(tree.search(MyInteger.valueOf(30)));
        Assert.assertTrue(tree.search(MyInteger.valueOf(35)));
        Assert.assertTrue(tree.search(MyInteger.valueOf(40)));
        Assert.assertTrue(tree.search(MyInteger.valueOf(50)));
        Assert.assertFalse(tree.search(MyInteger.valueOf(6)));

        new LevelOrderTraversal<>(tree).traverse();
        Assert.assertEquals("30-10-40-20-35-50-15", ResultHolder.getResult());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test3() {
        BinarySearchTree<MyInteger> tree = new BinarySearchTree<>();
        tree.insert(MyInteger.valueOf(30));
        tree.insert(MyInteger.valueOf(30));
    }

    @Test
    public void test4() {
        BinarySearchTree<MyInteger> binarySearchTree = TreeHelper.getBinarySearchTree();
        Assert.assertEquals(MyInteger.valueOf(1), binarySearchTree.findMin());
    }

    @Test
    public void test5() {
        BinarySearchTree<MyInteger> binarySearchTree = new BinarySearchTree<>();
        Assert.assertEquals(null, binarySearchTree.findMin());
    }

    @Test
    public void test6() {
        BinarySearchTree<MyInteger> binarySearchTree = TreeHelper.getBinarySearchTree();
        Assert.assertEquals(MyInteger.valueOf(12), binarySearchTree.findMax());
    }

    @Test
    public void test7() {
        BinarySearchTree<MyInteger> binarySearchTree = new BinarySearchTree<>();
        Assert.assertEquals(null, binarySearchTree.findMax());
    }

    @Test
    public void test8() {
        BinarySearchTree<MyInteger> binarySearchTree = TreeHelper.getBinarySearchTree();
        Assert.assertEquals(12, binarySearchTree.getNodeCount());
    }

    @Test
    public void test9() {
        BinarySearchTree<MyInteger> binarySearchTree = new BinarySearchTree<>();
        Assert.assertEquals(0, binarySearchTree.getNodeCount());
    }

    @Test
    public void test10() {
        BinarySearchTree<MyInteger> tree = new BinarySearchTree<>();
        tree.insert(MyInteger.valueOf(30));
        tree.insert(MyInteger.valueOf(10));
        tree.insert(MyInteger.valueOf(20));
        tree.insert(MyInteger.valueOf(40));
        tree.insert(MyInteger.valueOf(35));
        tree.insert(MyInteger.valueOf(50));
        tree.insert(MyInteger.valueOf(15));

        tree.delete(MyInteger.valueOf(15));
        LevelOrderTraversal<MyInteger> levelOrderTraversal = new LevelOrderTraversal<>(tree);
        levelOrderTraversal.traverse();
        Assert.assertEquals("30-10-40-20-35-50", ResultHolder.getResult());

        ResultHolder.clear();
        tree.delete(MyInteger.valueOf(50));
        levelOrderTraversal.traverse();
        Assert.assertEquals("30-10-40-20-35", ResultHolder.getResult());

        ResultHolder.clear();
        tree.delete(MyInteger.valueOf(10));
        levelOrderTraversal.traverse();
        Assert.assertEquals("30-20-40-35", ResultHolder.getResult());
    }

    @Test
    public void test11() {
        BinarySearchTree<MyInteger> tree = new BinarySearchTree<>();
        tree.insert(MyInteger.valueOf(30));
        tree.insert(MyInteger.valueOf(10));
        tree.insert(MyInteger.valueOf(20));
        tree.insert(MyInteger.valueOf(40));
        tree.insert(MyInteger.valueOf(35));
        tree.insert(MyInteger.valueOf(50));
        tree.insert(MyInteger.valueOf(15));

        tree.delete(MyInteger.valueOf(20));
        LevelOrderTraversal<MyInteger> levelOrderTraversal = new LevelOrderTraversal<>(tree);
        levelOrderTraversal.traverse();
        Assert.assertEquals("30-10-40-15-35-50", ResultHolder.getResult());

        tree.delete(MyInteger.valueOf(40));
        ResultHolder.clear();
        levelOrderTraversal.traverse();
        Assert.assertEquals("30-10-50-15-35", ResultHolder.getResult());
    }

    @Test(expected = NullPointerException.class)
    public void test12() {
        BinarySearchTree<MyInteger> tree = new BinarySearchTree<>();
        tree.delete(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test13() {
        BinarySearchTree<MyInteger> tree = TreeHelper.getBinarySearchTree();
        tree.delete(MyInteger.valueOf(100));
    }

    @Test
    public void test14() {
        BinarySearchTree<MyInteger> tree = new BinarySearchTree<>();
        tree.insert(MyInteger.valueOf(30));
        tree.insert(MyInteger.valueOf(10));
        tree.insert(MyInteger.valueOf(20));
        tree.insert(MyInteger.valueOf(40));
        tree.insert(MyInteger.valueOf(35));
        tree.insert(MyInteger.valueOf(50));
        tree.insert(MyInteger.valueOf(15));

        tree.delete(MyInteger.valueOf(30));
        LevelOrderTraversal<MyInteger> levelOrderTraversal = new LevelOrderTraversal<>(tree);
        levelOrderTraversal.traverse();
        Assert.assertEquals("35-10-40-20-50-15", ResultHolder.getResult());
    }

    @Test
    public void test15() {
        BinarySearchTree<MyInteger> tree = new BinarySearchTree<>();
        tree.insert(MyInteger.valueOf(30));
        tree.insert(MyInteger.valueOf(10));
        tree.insert(MyInteger.valueOf(20));
        tree.insert(MyInteger.valueOf(40));
        tree.insert(MyInteger.valueOf(35));
        tree.insert(MyInteger.valueOf(50));
        tree.insert(MyInteger.valueOf(15));

        tree.delete(MyInteger.valueOf(35));
        tree.delete(MyInteger.valueOf(30));
        LevelOrderTraversal<MyInteger> levelOrderTraversal = new LevelOrderTraversal<>(tree);
        levelOrderTraversal.traverse();
        Assert.assertEquals("40-10-50-20-15", ResultHolder.getResult());
    }

    @Test
    public void test16() {
        BinarySearchTree<MyInteger> tree = new BinarySearchTree<>();
        tree.insert(MyInteger.valueOf(8));
        tree.insert(MyInteger.valueOf(7));
        tree.insert(MyInteger.valueOf(10));
        tree.insert(MyInteger.valueOf(9));
        tree.insert(MyInteger.valueOf(11));
        tree.insert(MyInteger.valueOf(2));
        tree.insert(MyInteger.valueOf(1));
        tree.insert(MyInteger.valueOf(5));
        tree.insert(MyInteger.valueOf(3));
        tree.insert(MyInteger.valueOf(6));
        tree.insert(MyInteger.valueOf(4));

        tree.delete(MyInteger.valueOf(2));
        LevelOrderTraversal<MyInteger> levelOrderTraversal = new LevelOrderTraversal<>(tree);
        levelOrderTraversal.traverse();
        Assert.assertEquals("8-7-10-3-9-11-1-5-4-6", ResultHolder.getResult());
    }
}
