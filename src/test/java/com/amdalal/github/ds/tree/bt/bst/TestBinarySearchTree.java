package com.amdalal.github.ds.tree.bt.bst;

import com.amdalal.github.ds.tree.bt.traversal.LevelOrderTraversal;
import com.amdalal.github.ds.tree.MyInteger;
import com.amdalal.github.ds.tree.TreeHelper;
import junit.framework.Assert;
import org.junit.Test;

public class TestBinarySearchTree {

    @Test
    public void test1() {
        BinarySearchTree<MyInteger> tree = TreeHelper.getBinarySearchTree();
        Assert.assertTrue(tree.search(new MyInteger(1)));
        Assert.assertTrue(tree.search(new MyInteger(2)));
        Assert.assertTrue(tree.search(new MyInteger(3)));
        Assert.assertTrue(tree.search(new MyInteger(4)));
        Assert.assertTrue(tree.search(new MyInteger(5)));
        Assert.assertTrue(tree.search(new MyInteger(6)));
        Assert.assertTrue(tree.search(new MyInteger(7)));
        Assert.assertTrue(tree.search(new MyInteger(8)));
        Assert.assertTrue(tree.search(new MyInteger(9)));
        Assert.assertTrue(tree.search(new MyInteger(10)));
        Assert.assertTrue(tree.search(new MyInteger(11)));
        Assert.assertTrue(tree.search(new MyInteger(12)));
        Assert.assertFalse(tree.search(new MyInteger(13)));
        Assert.assertFalse(tree.search(new MyInteger(0)));
        Assert.assertFalse(tree.search(new MyInteger(-1)));
    }

    @Test
    public void test2() {
        BinarySearchTree<MyInteger> tree = new BinarySearchTree<>();
        tree.insert(new MyInteger(30));
        tree.insert(new MyInteger(10));
        tree.insert(new MyInteger(20));
        tree.insert(new MyInteger(40));
        tree.insert(new MyInteger(35));
        tree.insert(new MyInteger(50));
        tree.insert(new MyInteger(15));
        Assert.assertFalse(tree.search(new MyInteger(0)));
        Assert.assertTrue(tree.search(new MyInteger(10)));
        Assert.assertTrue(tree.search(new MyInteger(15)));
        Assert.assertTrue(tree.search(new MyInteger(20)));
        Assert.assertTrue(tree.search(new MyInteger(30)));
        Assert.assertTrue(tree.search(new MyInteger(35)));
        Assert.assertTrue(tree.search(new MyInteger(40)));
        Assert.assertTrue(tree.search(new MyInteger(50)));
        Assert.assertFalse(tree.search(new MyInteger(6)));

        MyInteger x = new MyInteger(-1);
        x.clear();
        LevelOrderTraversal<MyInteger> levelOrderTraversal = new LevelOrderTraversal<>(tree);
        levelOrderTraversal.traverse();
        Assert.assertEquals("30-10-40-20-35-50-15", x.getOutput());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test3() {
        BinarySearchTree<MyInteger> tree = new BinarySearchTree<>();
        tree.insert(new MyInteger(30));
        tree.insert(new MyInteger(30));
    }

    @Test
    public void test4() {
        BinarySearchTree<MyInteger> binarySearchTree = TreeHelper.getBinarySearchTree();
        Assert.assertEquals(new MyInteger(1), binarySearchTree.findMin());
    }

    @Test
    public void test5() {
        BinarySearchTree<MyInteger> binarySearchTree = new BinarySearchTree<>();
        Assert.assertEquals(null, binarySearchTree.findMin());
    }

    @Test
    public void test6() {
        BinarySearchTree<MyInteger> binarySearchTree = TreeHelper.getBinarySearchTree();
        Assert.assertEquals(new MyInteger(12), binarySearchTree.findMax());
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
        tree.insert(new MyInteger(30));
        tree.insert(new MyInteger(10));
        tree.insert(new MyInteger(20));
        tree.insert(new MyInteger(40));
        tree.insert(new MyInteger(35));
        tree.insert(new MyInteger(50));
        tree.insert(new MyInteger(15));

        tree.delete(new MyInteger(15));
        MyInteger x = new MyInteger(-1);
        x.clear();
        LevelOrderTraversal<MyInteger> levelOrderTraversal = new LevelOrderTraversal<>(tree);
        levelOrderTraversal.traverse();
        Assert.assertEquals("30-10-40-20-35-50", x.getOutput());

        tree.delete(new MyInteger(50));
        x.clear();
        levelOrderTraversal.traverse();
        Assert.assertEquals("30-10-40-20-35", x.getOutput());

        tree.delete(new MyInteger(10));
        x.clear();
        levelOrderTraversal.traverse();
        Assert.assertEquals("30-20-40-35", x.getOutput());
    }

    @Test
    public void test11() {
        BinarySearchTree<MyInteger> tree = new BinarySearchTree<>();
        tree.insert(new MyInteger(30));
        tree.insert(new MyInteger(10));
        tree.insert(new MyInteger(20));
        tree.insert(new MyInteger(40));
        tree.insert(new MyInteger(35));
        tree.insert(new MyInteger(50));
        tree.insert(new MyInteger(15));

        tree.delete(new MyInteger(20));
        MyInteger x = new MyInteger(-1);
        x.clear();
        LevelOrderTraversal<MyInteger> levelOrderTraversal = new LevelOrderTraversal<>(tree);
        levelOrderTraversal.traverse();
        Assert.assertEquals("30-10-40-15-35-50", x.getOutput());

        tree.delete(new MyInteger(40));
        x.clear();
        levelOrderTraversal.traverse();
        Assert.assertEquals("30-10-50-15-35", x.getOutput());
    }

    @Test(expected = NullPointerException.class)
    public void test12() {
        BinarySearchTree<MyInteger> tree = new BinarySearchTree<>();
        tree.delete(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test13() {
        BinarySearchTree<MyInteger> tree = TreeHelper.getBinarySearchTree();
        tree.delete(new MyInteger(100));
    }

    @Test
    public void test14() {
        BinarySearchTree<MyInteger> tree = new BinarySearchTree<>();
        tree.insert(new MyInteger(30));
        tree.insert(new MyInteger(10));
        tree.insert(new MyInteger(20));
        tree.insert(new MyInteger(40));
        tree.insert(new MyInteger(35));
        tree.insert(new MyInteger(50));
        tree.insert(new MyInteger(15));

        tree.delete(new MyInteger(30));
        MyInteger x = new MyInteger(-1);
        x.clear();
        LevelOrderTraversal<MyInteger> levelOrderTraversal = new LevelOrderTraversal<>(tree);
        levelOrderTraversal.traverse();
        Assert.assertEquals("35-10-40-20-50-15", x.getOutput());
    }

    @Test
    public void test15() {
        BinarySearchTree<MyInteger> tree = new BinarySearchTree<>();
        tree.insert(new MyInteger(30));
        tree.insert(new MyInteger(10));
        tree.insert(new MyInteger(20));
        tree.insert(new MyInteger(40));
        tree.insert(new MyInteger(35));
        tree.insert(new MyInteger(50));
        tree.insert(new MyInteger(15));

        tree.delete(new MyInteger(35));
        tree.delete(new MyInteger(30));
        MyInteger x = new MyInteger(-1);
        x.clear();
        LevelOrderTraversal<MyInteger> levelOrderTraversal = new LevelOrderTraversal<>(tree);
        levelOrderTraversal.traverse();
        Assert.assertEquals("40-10-50-20-15", x.getOutput());
    }

    @Test
    public void test16() {
        BinarySearchTree<MyInteger> tree = new BinarySearchTree<>();
        tree.insert(new MyInteger(8));
        tree.insert(new MyInteger(7));
        tree.insert(new MyInteger(10));
        tree.insert(new MyInteger(9));
        tree.insert(new MyInteger(11));
        tree.insert(new MyInteger(2));
        tree.insert(new MyInteger(1));
        tree.insert(new MyInteger(5));
        tree.insert(new MyInteger(3));
        tree.insert(new MyInteger(6));
        tree.insert(new MyInteger(4));

        tree.delete(new MyInteger(2));
        MyInteger x = new MyInteger(-1);
        x.clear();
        LevelOrderTraversal<MyInteger> levelOrderTraversal = new LevelOrderTraversal<>(tree);
        levelOrderTraversal.traverse();
        Assert.assertEquals("8-7-10-3-9-11-1-5-4-6", x.getOutput());
    }
}
