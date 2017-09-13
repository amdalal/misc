package com.amdalal.github.ds.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    private Node root = new Node();

    public void insert(String input) {
        char[] inputCharArray = input.toCharArray();
        Node currentNode = root;
        for (int i = 0; i < inputCharArray.length; i++) {
            Node childNode = currentNode.children.computeIfAbsent(inputCharArray[i], k -> new Node());
            currentNode = childNode;
        }
        currentNode.wordComplete = true;
    }

    private class Node {
        Map<Character, Node> children;
        boolean              wordComplete;

        public Node() {
            this.children = new HashMap<>();
        }
    }
}
