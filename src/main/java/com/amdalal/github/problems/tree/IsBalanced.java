package com.amdalal.github.problems.tree;

/**
 * Is binary tree balanced?
 */
public class IsBalanced {

    public static int test(Node root) {
        if (root == null) {
            return -1;
        }
        int l = test(root.left);
        if (l == -10) {
            return -10;
        }
        int r = test(root.right);
        if (r == -10) {
            return -10;
        }
        return Math.abs(l - r) > 1 ? -10 : Math.max(l, r) + 1;
    }
}
