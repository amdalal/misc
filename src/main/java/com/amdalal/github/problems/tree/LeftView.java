package com.amdalal.github.problems.tree;

import java.util.ArrayList;
import java.util.List;

import com.amdalal.github.ds.Visitable;
import com.amdalal.github.ds.tree.bt.BinaryTree;
import com.amdalal.github.ds.tree.bt.BinaryTreeNode;

public class LeftView<T extends Visitable> {

    public List<T> build(BinaryTree<T> node) {
        return doBuild(node.getRoot(), 0, 0, 0, true, new ArrayList<>());
    }

    private List<T> doBuild(BinaryTreeNode<T> node, int prevX, int x, int y, boolean left, List<T> output) {
        if (node != null) {
            int newX = left ? x - 1 : x + 1;
            doBuild(node.getLeftChild(), x, newX, y + 1, true, output);
            if (newX < prevX) {
                output.add(node.getData());
            }
            doBuild(node.getRightChild(), x, newX, y + 1, false, output);
        }
        return output;
    }
}
