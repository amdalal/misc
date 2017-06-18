package com.amdalal.github.problems.misc;

import com.amdalal.github.ds.Visitable;
import com.amdalal.github.ds.tree.bt.BinaryTree;
import com.amdalal.github.ds.tree.bt.BinaryTreeNode;

public class InvertBinaryTree<T extends Visitable> {

    public BinaryTree<T> invert(BinaryTree<T> tree) {
        BinaryTree<T> returnTree = new BinaryTree<>();
        returnTree.setRoot(invert(tree.getRoot()));
        return returnTree;
    }

    private BinaryTreeNode<T> invert(BinaryTreeNode<T> n) {
        if (n.getLeftChild() != null) {
            invert(n.getLeftChild());
        }
        if (n.getRightChild() != null) {
            invert(n.getRightChild());
        }
        if (n.getLeftChild() != null || n.getRightChild() != null) {
            BinaryTreeNode temp = n.getLeftChild();
            n.setLeftChild(n.getRightChild());
            n.setRightChild(temp);
        }
        return n;
    }
}
