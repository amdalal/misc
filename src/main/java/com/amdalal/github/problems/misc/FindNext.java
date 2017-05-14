package com.amdalal.github.problems.misc;

public class FindNext {

    public static Node find(Node node, Node ref) {
        if (node.right != null && ref != null && node.right != ref) {
            return findLeftMost(node.right);
        } else if (node.parent != null && node.parent.left == node) {
            return node.parent;
        } else if (node.parent != null) {
            return find(node.parent, node);
        }
        return null;
    }

    private static Node findLeftMost(Node node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
