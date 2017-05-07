package com.amdalal.github.ds.tree.bt;

import com.amdalal.github.ds.Visitable;

public class BinaryTreeNode<T extends Visitable> {

    private T data;

    private BinaryTreeNode<T> parent;

    private BinaryTreeNode<T> leftChild;

    private BinaryTreeNode<T> rightChild;

    public BinaryTreeNode(T data) {
        this.data = data;
    }

    public final BinaryTreeNode<T> addLeftChild(BinaryTreeNode<T> node) {
        if (getLeftChild() != null) {
            throw new IllegalArgumentException("leftChild child is already present");
        }
        node.parent = this;
        this.leftChild = node;
        return leftChild;
    }

    public final BinaryTreeNode<T> addRightChild(BinaryTreeNode<T> node) {
        if (getRightChild() != null) {
            throw new IllegalArgumentException("rightChild child is already present");
        }
        node.parent = this;
        this.rightChild = node;
        return node;
    }

    public final T getData() {
        return data;
    }

    public final BinaryTreeNode<T> getParent() {
        return parent;
    }

    public final void setParent(BinaryTreeNode<T> parent) {
        this.parent = parent;
    }

    public final BinaryTreeNode<T> getLeftChild() {
        return leftChild;
    }

    public final void setLeftChild(BinaryTreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public final BinaryTreeNode<T> getRightChild() {
        return rightChild;
    }

    public final void setRightChild(BinaryTreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    public final void setData(T data) {
        this.data = data;
    }
}
