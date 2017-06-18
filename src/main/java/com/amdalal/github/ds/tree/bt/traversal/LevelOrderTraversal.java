package com.amdalal.github.ds.tree.bt.traversal;

import com.amdalal.github.ds.tree.bt.BinaryTree;
import com.amdalal.github.ds.list.LinkedList;
import com.amdalal.github.ds.list.impl.SinglyLinkedList;
import com.amdalal.github.ds.tree.Traversal;
import com.amdalal.github.ds.Visitable;
import com.amdalal.github.ds.tree.bt.BinaryTreeNode;

public class LevelOrderTraversal<T extends Visitable> implements Traversal<T> {

    private BinaryTree<T> binaryTree;

    private LinkedList<BinaryTreeNode<T>> list = new SinglyLinkedList<>();

    public LevelOrderTraversal(BinaryTree<T> binaryTree) {
        this.binaryTree = binaryTree;
    }

    @Override
    public void traverse() {
        list.pushBack(binaryTree.getRoot());
        while (!list.isEmpty()) {
            BinaryTreeNode<T> n = list.popFront();
            n.getData().visit();
            if (n.getLeftChild() != null) {
                list.pushBack(n.getLeftChild());
            }
            if (n.getRightChild() != null) {
                list.pushBack(n.getRightChild());
            }
        }
    }
}
