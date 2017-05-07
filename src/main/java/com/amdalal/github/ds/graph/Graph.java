package com.amdalal.github.ds.graph;

import java.util.HashSet;
import java.util.Set;

import com.amdalal.github.ds.Visitable;

public class Graph<T extends Visitable> {

    private Node<T>[] vertices;
    private int       count = 0;

    public Graph(int size) {
        this.vertices = new Node[size];
    }

    public Graph<T> addVertex(Node<T> node) {
        vertices[count++] = node;
        return this;
    }

    public Graph<T> and(Node<T> node) {
        addVertex(node);
        return this;
    }

    public void dfs() {
        Set<Node<T>> visited = new HashSet<>();
        for (Node<T> node : this.vertices) {
            dfsNode(node, visited);
        }
    }

    private void dfsNode(Node<T> node, Set<Node<T>> visited) {
        if (!visited.contains(node)) {
            node.getData().visit();
            visited.add(node);
            for (Node<T> connection : node.getConnections()) {
                dfsNode(connection, visited);
            }
        }
    }
}


