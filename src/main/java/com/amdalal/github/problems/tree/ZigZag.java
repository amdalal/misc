package com.amdalal.github.problems.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.amdalal.github.ds.Visitable;
import com.amdalal.github.ds.tree.bt.BinaryTree;
import com.amdalal.github.ds.tree.bt.BinaryTreeNode;

public class ZigZag<T extends Visitable> {

    public List<T> zigzag(BinaryTree<T> tree) {
        BinaryTreeNode<T> root = tree.getRoot();
        List<T> output = new ArrayList<>();
        if (root != null) {
            Stack<BinaryTreeNode<T>> s1 = new Stack<>();
            Stack<BinaryTreeNode<T>> s2 = new Stack<>();
            s1.push(root);
            boolean leftToRight = true;
            while (!s1.isEmpty() || !s2.isEmpty()) {
                if (leftToRight) {
                    BinaryTreeNode<T> n = s1.pop();
                    output.add(n.getData());
                    leftToRight = zigZagNode(n.getLeftChild(), n.getRightChild(), s1, s2, true);
                } else {
                    BinaryTreeNode<T> n = s2.pop();
                    output.add(n.getData());
                    leftToRight = zigZagNode(n.getRightChild(), n.getLeftChild(), s2, s1, false);
                }
            }
        }
        return output;
    }

    private boolean zigZagNode(BinaryTreeNode<T> first, BinaryTreeNode<T> second, Stack<BinaryTreeNode<T>> iterationStack, Stack<BinaryTreeNode<T>> spareStack,
            boolean direction) {
        if (first != null) {
            spareStack.push(first);
        }
        if (second != null) {
            spareStack.push(second);
        }
        if (iterationStack.isEmpty()) {
            direction = !direction;
        }
        return direction;
    }
}
