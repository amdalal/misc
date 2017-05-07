package com.amdalal.github.ds.tree.bt;

import com.amdalal.github.ds.tree.Tree;
import com.amdalal.github.ds.Visitable;

public class BinaryTree<T extends Visitable> implements Tree<T> {

    private BinaryTreeNode<T> root;

    public BinaryTreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode<T> root) {
        if (root == null) {
            throw new NullPointerException("root node cannot be null");
        }
        this.root = root;
    }
}
