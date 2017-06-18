package com.amdalal.github.ds.tree.bt.traversal;

import com.amdalal.github.ds.tree.Traversal;
import com.amdalal.github.ds.Visitable;
import com.amdalal.github.ds.tree.bt.BinaryTree;
import com.amdalal.github.ds.tree.bt.BinaryTreeNode;

public class PostOrderTraversal<T extends Visitable> implements Traversal<T> {

    private BinaryTree<T> binaryTree;

    public PostOrderTraversal(BinaryTree<T> binaryTree) {
        this.binaryTree = binaryTree;
    }

    @Override
    public void traverse() {
        doTraverse(binaryTree.getRoot());
    }

    public void doTraverse(BinaryTreeNode<T> node) {
        if (node != null) {
            doTraverse(node.getLeftChild());
            doTraverse(node.getRightChild());
            node.getData().visit();
        }
    }
}
