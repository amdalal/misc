package com.amdalal.github.problems.misc;

import java.util.ArrayList;
import java.util.List;

import com.amdalal.github.ds.list.LinkedList;
import com.amdalal.github.ds.list.impl.SinglyLinkedList;

public class LinkedListForEachLevelOfBT {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.left = n2;
        n1.right = n3;
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n2.left = n4;
        n2.right = n5;
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        n3.left = n6;
        n3.right = n7;

        for (LinkedList<Node> list : getListOfLists(n1)) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.elementAt(i).data);
            }
            System.out.println();
        }

    }

    private static List<LinkedList<Node>> getListOfLists(Node root) {
        List<LinkedList<Node>> output = new ArrayList<>();
        LinkedList<Node> q = new SinglyLinkedList<>();

        q.pushBack(root);
        q.pushBack(null);

        LinkedList<Node> l = new SinglyLinkedList<>();
        boolean b = false;
        while (!q.isEmpty()) {
            Node n = q.popFront();
            if (n != null)
                l.pushBack(n);
            if (n == null) {
                output.add(l);
                l = new SinglyLinkedList<>();
                q.pushBack(null);
                if (b) {
                    return output;
                }
                b = true;
            } else {
                b = false;
                if (n.left != null)
                    q.pushBack(n.left);
                if (n.right != null)
                    q.pushBack(n.right);
            }
        }
        return output;
    }
}
