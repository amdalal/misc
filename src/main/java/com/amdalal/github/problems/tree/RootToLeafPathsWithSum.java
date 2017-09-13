package com.amdalal.github.problems.tree;

import java.util.ArrayList;

public class RootToLeafPathsWithSum {

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        traverse(root, output, path, 0, sum);
        return output;
    }

    private void traverse(TreeNode node, ArrayList<ArrayList<Integer>> output, ArrayList<Integer> path, int sumTillParent, int sum) {
        if (node != null) {
            int sumAtNode = sumTillParent + node.val;
            path.add(node.val);
            if (node.left == null && node.right == null && sumAtNode == sum) {
                output.add(new ArrayList<>(path));
            }
            if (node.left != null) {
                traverse(node.left, output, path, sumAtNode, sum);
                path.remove(path.size() - 1);
            }
            if (node.right != null) {
                traverse(node.right, output, path, sumAtNode, sum);
                path.remove(path.size() - 1);
            }
        }
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
