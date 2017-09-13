package com.amdalal.github.problems.tree;

/**
 * Transform sorted array to BST
 */
public class ArrayToBST {

    public static Node transform(int[] input) {
        return doTransform(input, 0, input.length - 1);
    }

    private static Node doTransform(int[] input, int startIdx, int endIdx) {
        if (startIdx > endIdx)
            return null;
        int midIdx = (startIdx + endIdx) / 2;
        Node node = new Node(input[midIdx]);
        node.left = doTransform(input, startIdx, midIdx - 1);
        node.right = doTransform(input, midIdx + 1, endIdx);
        return node;
    }
}
