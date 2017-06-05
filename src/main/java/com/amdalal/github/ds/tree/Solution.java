package com.amdalal.github.ds.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        int[] a = { 1, 2, 3 };
        int[] b = { 2, 3, 2 };
        System.out.println(tasks(6, a, b));
    }

    static int tasks(int n, int[] a, int[] b) {
        Graph g = prepareGraph(n, a, b);
        int counter = 0;
        if (g != null) {
            Map<Node, Integer> visited = new HashMap<>(g.vertices.length);
            for (Node node : g.vertices) {
                if (visited.get(node) == null) {
                    counter = visitNode(node, visited, counter);
                }
            }
        }
        return counter;
    }

    private static int visitNode(Node node, Map<Node, Integer> visited, int counter) {
        if (visited.get(node) == null) {
            visited.put(node, ++counter);
            for (Node connection : node.connections) {
                counter = visitNode(connection, visited, counter);
            }
        } else {
            return visited.get(node);
        }
        return counter;
    }

    private static Graph prepareGraph(int n, int[] a, int[] b) {
        Graph g = new Graph(n);
        Map<Integer, Node> nodes = new HashMap<>(a.length);
        if (a.length != b.length) {
            return null;
        }
        for (int i = 1; i <= n; i++) {
            Node thisNode = new Node(i);
            nodes.put(i, thisNode);
            g.addVertex(thisNode);
        }
        for (int i = 0; i < a.length; i++) {
            Node from = nodes.get(a[i]);
            Node to = nodes.get(b[i]);
            from.connect(to);
        }
        return g;
    }

    static class Node {
        int        id;
        List<Node> connections = new ArrayList<>();

        public Node(int id) {
            this.id = id;
        }

        public Node connect(Node peer) {
            this.connections.add(peer);
            return this;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Node node = (Node) o;
            return id == node.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

    static class Graph {
        Node[] vertices;
        int    count = 0;

        public Graph(int num) {
            vertices = new Node[num];
        }

        public Graph addVertex(Node node) {
            vertices[count++] = node;
            return this;
        }

        public Graph and(Node node) {
            addVertex(node);
            return this;
        }
    }
}
