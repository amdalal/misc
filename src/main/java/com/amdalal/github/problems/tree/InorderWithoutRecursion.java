package com.amdalal.github.problems.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderWithoutRecursion {
    public ArrayList<Integer> inorderTraversal(TreeNode a) {
        Stack<TreeNode> s = new Stack<>();
        List<TreeNode> processed = new ArrayList<>();
        ArrayList<Integer> output = new ArrayList<>();
        s.push(a);
        while (!s.isEmpty()) {
            TreeNode x = s.peek();
            if (x.left != null && !processed.contains(x.left)) {
                s.push(x.left);
            } else {
                if (!processed.contains(x)) {
                    TreeNode y = s.pop();
                    output.add(y.val);
                    processed.add(y);
                }
                if (x.right != null) {
                    s.push(x.right);
                }
            }
        }
        return output;
    }

    class TreeNode {
        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
