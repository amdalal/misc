package com.amdalal.github.problems.linkedlist;

public class ReverseLinkedList {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.next = new Node(2);
        n1.next.next = new Node(3);
        n1.next.next.next = new Node(4);
        n1.next.next.next.next = new Node(5);
        Node newHead = reverse(n1);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }

    public static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    private static class Node {
        int  val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
