package com.amdalal.github.ds.tree.bt.traversal;

import com.amdalal.github.ds.tree.Traversable;
import com.amdalal.github.ds.tree.TreeEntry;
import com.amdalal.github.ds.tree.bt.BinaryTree;
import com.amdalal.github.ds.tree.bt.BinaryTreeNode;

public class PostOrderTraversal<T extends TreeEntry> implements Traversable {

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
