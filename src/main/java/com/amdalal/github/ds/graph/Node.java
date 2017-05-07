package com.amdalal.github.ds.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.amdalal.github.ds.Visitable;

public class Node<T extends Visitable> {
    private T             data;
    private int           id;
    private List<Node<T>> connections = new ArrayList<>();

    public Node(int id, T data) {
        this.id = id;
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public Node<T> connect(Node<T> peer) {
        this.connections.add(peer);
        return this;
    }

    public int getId() {
        return id;
    }

    public List<Node<T>> getConnections() {
        return connections;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that)
            return true;
        if (that == null || getClass() != that.getClass())
            return false;
        Node<?> node = (Node<?>) that;
        return id == node.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}