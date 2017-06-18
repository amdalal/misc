package com.amdalal.github.ds.tree.bt.traversal;

import com.amdalal.github.ds.tree.Traversal;
import com.amdalal.github.ds.tree.bt.BinaryTree;
import com.amdalal.github.ds.Visitable;
import com.amdalal.github.ds.tree.bt.BinaryTreeNode;

public class InOrderTraversal<T extends Visitable> implements Traversal<T> {

    private BinaryTree<T> binaryTree;

    public InOrderTraversal(BinaryTree<T> binaryTree) {
        this.binaryTree = binaryTree;
    }

    @Override
    public void traverse() {
        doTraverse(binaryTree.getRoot());
    }

    private void doTraverse(BinaryTreeNode<T> node) {
        if (node != null) {
            doTraverse(node.getLeftChild());
            node.getData().visit();
            doTraverse(node.getRightChild());
        }
    }
}
