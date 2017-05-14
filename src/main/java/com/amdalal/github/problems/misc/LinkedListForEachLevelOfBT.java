package com.amdalal.github.problems.misc;

import java.util.ArrayList;
import java.util.List;

import com.amdalal.github.ds.list.LinkedList;
import com.amdalal.github.ds.list.impl.SinglyLinkedList;

public class LinkedListForEachLevelOfBT {

    public static List<LinkedList<Node>> getListOfLists(Node root) {
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
