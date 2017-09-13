package com.amdalal.github.problems.tree;

import java.util.Objects;

class Node {
    Integer data;
    Node    left;
    Node    right;
    Node    parent;

    Node(Integer data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Node node = (Node) o;
        return Objects.equals(data, node.data) && Objects.equals(left, node.left) && Objects.equals(right, node.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, left, right);
    }
}
