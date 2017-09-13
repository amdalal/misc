package com.amdalal.github.problems.tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amdalal.github.ds.Visitable;
import com.amdalal.github.ds.tree.bt.BinaryTree;
import com.amdalal.github.ds.tree.bt.BinaryTreeNode;

public class RightView<T extends Visitable> {

    public List<T> build(BinaryTree<T> tree) {
        Map<Integer, T> cache = new HashMap<>();
        doBuild(tree.getRoot(), 0, cache);
        return (List<T>) cache.values();
    }

    private void doBuild(BinaryTreeNode<T> node, int level, Map<Integer, T> cache) {
        if (node == null) {
            return;
        }
        doBuild(node.getLeftChild(), level + 1, cache);
        doBuild(node.getRightChild(), level + 1, cache);
        if (node.getRightChild() != null) {
            cache.put(level, node.getRightChild().getData());
        }
    }
}
