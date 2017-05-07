package com.amdalal.github.ds.tree;

import com.amdalal.github.ds.tree.bt.BinaryTree;
import com.amdalal.github.ds.tree.bt.bst.BinarySearchTree;
import com.amdalal.github.ds.tree.bt.BinaryTreeNode;

public abstract class TreeHelper {

    public static BinaryTree<MyInteger> getTree() {
        BinaryTree<MyInteger> t = new BinaryTree<>();
        BinaryTreeNode<MyInteger> n1 = new BinaryTreeNode<>((new MyInteger(1)));
        BinaryTreeNode<MyInteger> n2 = n1.addLeftChild(new BinaryTreeNode<>(new MyInteger(2)));

        BinaryTreeNode<MyInteger> n3 = n1.addRightChild(new BinaryTreeNode<>(new MyInteger(3)));

        BinaryTreeNode<MyInteger> n4 = n2.addLeftChild(new BinaryTreeNode<>(new MyInteger(4)));
        BinaryTreeNode<MyInteger> n5 = n2.addRightChild(new BinaryTreeNode<>(new MyInteger(5)));

        BinaryTreeNode<MyInteger> n8 = n5.addLeftChild(new BinaryTreeNode<>(new MyInteger(8)));
        BinaryTreeNode<MyInteger> n9 = n5.addRightChild(new BinaryTreeNode<>(new MyInteger(9)));

        BinaryTreeNode<MyInteger> n6 = n3.addLeftChild(new BinaryTreeNode<>(new MyInteger(6)));
        BinaryTreeNode<MyInteger> n7 = n3.addRightChild(new BinaryTreeNode<>(new MyInteger(7)));

        BinaryTreeNode<MyInteger> n10 = n7.addLeftChild(new BinaryTreeNode<>(new MyInteger(10)));
        BinaryTreeNode<MyInteger> n11 = n7.addRightChild(new BinaryTreeNode<>(new MyInteger(11)));
        BinaryTreeNode<MyInteger> n12 = n11.addRightChild(new BinaryTreeNode<>(new MyInteger(12)));

        t.setRoot(n1);
        return t;
    }

    public static BinarySearchTree<MyInteger> getBinarySearchTree() {
        BinarySearchTree<MyInteger> t = new BinarySearchTree<>();
        BinaryTreeNode<MyInteger> n1 = new BinaryTreeNode<>((new MyInteger(6)));
        BinaryTreeNode<MyInteger> n2 = n1.addLeftChild(new BinaryTreeNode<>(new MyInteger(2)));
        BinaryTreeNode<MyInteger> n3 = n1.addRightChild(new BinaryTreeNode<>(new MyInteger(8)));

        BinaryTreeNode<MyInteger> n4 = n2.addLeftChild(new BinaryTreeNode<>(new MyInteger(1)));
        BinaryTreeNode<MyInteger> n5 = n2.addRightChild(new BinaryTreeNode<>(new MyInteger(4)));

        BinaryTreeNode<MyInteger> n8 = n5.addLeftChild(new BinaryTreeNode<>(new MyInteger(3)));
        BinaryTreeNode<MyInteger> n9 = n5.addRightChild(new BinaryTreeNode<>(new MyInteger(5)));

        BinaryTreeNode<MyInteger> n6 = n3.addLeftChild(new BinaryTreeNode<>(new MyInteger(7)));
        BinaryTreeNode<MyInteger> n7 = n3.addRightChild(new BinaryTreeNode<>(new MyInteger(10)));

        BinaryTreeNode<MyInteger> n10 = n7.addLeftChild(new BinaryTreeNode<>(new MyInteger(9)));
        BinaryTreeNode<MyInteger> n11 = n7.addRightChild(new BinaryTreeNode<>(new MyInteger(11)));
        BinaryTreeNode<MyInteger> n12 = n11.addRightChild(new BinaryTreeNode<>(new MyInteger(12)));

        t.setRoot(n1);
        return t;
    }
}
