package com.amdalal.github.ds.graph;

import com.amdalal.github.ds.tree.MyInteger;

public class GraphHelper {
    public static Graph<MyInteger> getGraph() {
        Graph<MyInteger> g = new Graph<>(7);

        Node<MyInteger> n1 = new Node<>(1, MyInteger.valueOf(1));
        Node<MyInteger> n2 = new Node<>(2, MyInteger.valueOf(2));
        Node<MyInteger> n3 = new Node<>(3, MyInteger.valueOf(3));
        Node<MyInteger> n4 = new Node<>(4, MyInteger.valueOf(4));
        Node<MyInteger> n5 = new Node<>(5, MyInteger.valueOf(5));
        Node<MyInteger> n6 = new Node<>(6, MyInteger.valueOf(6));
        Node<MyInteger> n7 = new Node<>(7, MyInteger.valueOf(7));

        g.addVertex(n1).and(n2).and(n3).and(n4).and(n5).and(n6).and(n7);

        n1.connect(n2).connect(n4).connect(n7);
        n2.connect(n1).connect(n6).connect(n3);
        n3.connect(n2).connect(n6).connect(n4);
        n4.connect(n1).connect(n3).connect(n5).connect(n7);
        n5.connect(n4).connect(n7);
        n6.connect(n2).connect(n3);
        n7.connect(n1).connect(n4).connect(n5);
        return g;
    }
}
