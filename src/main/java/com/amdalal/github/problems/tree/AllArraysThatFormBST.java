package com.amdalal.github.problems.tree;

import java.util.ArrayList;
import java.util.LinkedList;

public class AllArraysThatFormBST {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        n2.left = n1;
        n2.right = n3;
        n1.parent = n2;
        n3.parent = n2;
        findAll(n2);
        System.out.println("Done");
    }

    public static ArrayList<LinkedList<Integer>> findAll(Node n) {
        ArrayList<LinkedList<Integer>> output = new ArrayList<>();
        if (n == null) {
            output.add(new LinkedList<>());
            return output;
        }
        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(n.data);
        ArrayList<LinkedList<Integer>> left = findAll(n.left);
        ArrayList<LinkedList<Integer>> right = findAll(n.right);

        for (LinkedList<Integer> l : left) {
            for (LinkedList<Integer> r : right) {
                ArrayList<LinkedList<Integer>> weaved = new ArrayList<>();
                weave(l, r, weaved, prefix);
                output.addAll(weaved);
            }
        }
        return output;
    }

    private static void weave(LinkedList<Integer> left, LinkedList<Integer> right, ArrayList<LinkedList<Integer>> weaved, LinkedList<Integer> prefix) {
        if (left.size() == 0 || right.size() == 0) {
            LinkedList<Integer> t = (LinkedList<Integer>) prefix.clone();
            t.addAll(left);
            t.addAll(right);
            weaved.add(t);
            return;
        }
        Integer h = left.removeFirst();
        prefix.addLast(h);
        weave(left, right, weaved, prefix);
        prefix.removeLast();
        left.addFirst(h);

        h = right.removeFirst();
        prefix.addLast(h);
        weave(left, right, weaved, prefix);
        prefix.removeLast();
        right.addFirst(h);
    }
}
