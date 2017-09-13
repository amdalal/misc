package com.amdalal.github.problems.linkedlist;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseWordByWord {

    public static void main(String[] args) {
        Node a = new Node('A');
        a.next = new Node('B');
        a.next.next = new Node('D');
        a.next.next.next = new Node('E');
        a.next.next.next.next = new Node(' ');
        a.next.next.next.next.next = new Node('F');
        a.next.next.next.next.next.next = new Node('G');
        a.next.next.next.next.next.next.next = new Node('H');
        a.next.next.next.next.next.next.next.next = new Node(' ');
        a.next.next.next.next.next.next.next.next.next = new Node('I');
        a.next.next.next.next.next.next.next.next.next.next = new Node('J');
        Node newHead = reverseWordByWord(a);
        while (newHead != null) {
            System.out.println(newHead.c);
            newHead = newHead.next;
        }
    }

    public static Node reverseWordByWord(Node head) {
        Queue<Node> q = new LinkedList<>();
        q.add(head);
        Node newHead = null;
        Node newTail = null;
        while (!q.isEmpty()) {
            Node node = q.poll();
            HeadTail ht = doReverse(node, node);
            if (newHead == null) {
                newHead = ht.head;
            }
            if (newTail != null) {
                newTail.next = ht.head;
            } else
                newTail = ht.tail;
            if (ht.tail != null)
                ht.originalHead.next = ht.tail;
            head = ht.tail;
            if (head != null && head.c == ' ') {
                q.add(head.next);
            }
        }
        return newHead;
    }

    public static HeadTail doReverse(Node originalHead, Node head) {
        if (head.next == null || head.next.c == ' ') {
            return new HeadTail(head, head.next, originalHead);
        }
        HeadTail ht = doReverse(originalHead, head.next);
        head.next.next = head;
        head.next = null;
        return ht;
    }

    private static class HeadTail {
        Node head;
        Node tail;
        Node originalHead;

        HeadTail(Node head, Node tail, Node originalHead) {
            this.head = head;
            this.tail = tail;
            this.originalHead = originalHead;
        }
    }

    private static class Node {
        char c;
        Node next;

        public Node(char c) {
            this.c = c;
        }
    }
}
