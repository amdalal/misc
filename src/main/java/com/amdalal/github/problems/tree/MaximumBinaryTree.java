package com.amdalal.github.problems.tree;

/**
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow: The root is
 * the maximum number in the array. The left subtree is the maximum tree constructed from left part subarray divided by
 * the maximum number. The right subtree is the maximum tree constructed from right part subarray divided by the maximum
 * number. Construct the maximum tree by the given array and output the root node of this tree.
 **/
public class MaximumBinaryTree {

    public static void main(String[] args) {
        MaximumBinaryTree mbt = new MaximumBinaryTree();
        int[] nums = { 3, 2, 1, 6, 0, 5 };
        TreeNode node = mbt.constructMaximumBinaryTree(nums);
        System.out.println("done");
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return doConstructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    private TreeNode doConstructMaximumBinaryTree(int[] nums, int startIdx, int endIdx) {
        if (startIdx <= endIdx && startIdx >= 0 && endIdx >= 0) {
            int maxIdx = findMaxIndex(nums, startIdx, endIdx);
            TreeNode node = new TreeNode(nums[maxIdx]);
            node.left = doConstructMaximumBinaryTree(nums, startIdx, maxIdx - 1);
            node.right = doConstructMaximumBinaryTree(nums, maxIdx + 1, endIdx);
            return node;
        }
        return null;
    }

    private int findMaxIndex(int[] nums, int startIdx, int endIdx) {
        int maxIdx = startIdx;
        for (int i = startIdx; i <= endIdx; i++) {
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    private static class TreeNode {
        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}