package com.amdalal.github.ds.tree.bt.traversal;

import com.amdalal.github.ds.tree.Traversable;
import com.amdalal.github.ds.tree.TreeEntry;
import com.amdalal.github.ds.tree.bt.BinaryTree;
import com.amdalal.github.ds.tree.bt.BinaryTreeNode;

public class PreOrderTraversal<T extends TreeEntry> implements Traversable {

    private BinaryTree<T> binaryTree;

    private BinaryTreeNode<T> lastVisitedNode;

    public PreOrderTraversal(BinaryTree<T> binaryTree) {
        this.binaryTree = binaryTree;
        lastVisitedNode = null;
    }

    @Override
    public void traverse() {
        doTraverse(binaryTree.getRoot());
    }

    private void doTraverse(BinaryTreeNode<T> node) {
        if (node != null) {
            node.getData().visit();
            doTraverse(node.getLeftChild());
            doTraverse(node.getRightChild());
        }
    }

    public T next() {
        if (lastVisitedNode == null) {
            return visitNode(binaryTree.getRoot());
        }
        if (lastVisitedNode.getLeftChild() != null) {
            return visitNode(lastVisitedNode.getLeftChild());
        } else if (lastVisitedNode.getRightChild() != null) {
            return visitNode(lastVisitedNode.getRightChild());
        } else {
            if (lastVisitedNode.getParent() == null) {
                return null;
            } else {
                BinaryTreeNode<T> nextVisitableNode = findNextVisitableNode(lastVisitedNode);
                if (nextVisitableNode != null) {
                    return visitNode(nextVisitableNode);
                } else {
                    return null;
                }
            }
        }
    }

    private BinaryTreeNode<T> findNextVisitableNode(BinaryTreeNode<T> nodeInQuestion) {
        if (nodeInQuestion.getParent().getParent() == null && binaryTree.getRoot().getRightChild() == nodeInQuestion) {
            return null;
        }
        if (nodeInQuestion.getParent().getLeftChild() == nodeInQuestion || nodeInQuestion.getParent() == null) {
            return nodeInQuestion.getParent().getRightChild();
        } else {
            return findNextVisitableNode(nodeInQuestion.getParent());
        }
    }

    private T visitNode(BinaryTreeNode<T> node) {
        lastVisitedNode = node;
        node.getData().visit();
        return node.getData();
    }
}
