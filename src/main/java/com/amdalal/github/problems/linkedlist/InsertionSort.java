package com.amdalal.github.problems.linkedlist;

public class InsertionSort {

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(4);
//        head.next.next.next = new ListNode(1);
//        head.next.next.next.next = new ListNode(1);
        head = insertionSortList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode insertionSortList(ListNode a) {
        ListNode head = a;
        ListNode candidate = a.next;
        ListNode candidatePrev = a;
        ListNode compareToNode = a;
        ListNode compareToNodePrev = null;
        while (candidate != null) {
            if (candidate.val < compareToNode.val) {
                ListNode newNode = new ListNode(candidate.val);
                if (compareToNodePrev != null) {
                    compareToNodePrev.next = newNode;
                } else {
                    head = newNode;
                }
                newNode.next = compareToNode;

                if (candidate.next != null) {
                    ListNode nodeToDelete = candidate.next;
                    candidate.val = nodeToDelete.val;
                    candidate.next = nodeToDelete.next;
                    nodeToDelete.next = null;
                } else {
                    candidatePrev.next = null;
                    candidate = null;
                }
                compareToNode = head;
                compareToNodePrev = null;
            } else if (candidate == compareToNode) {
                candidatePrev = candidate;
                candidate = candidate.next;
                compareToNode = head;
                compareToNodePrev = null;
            } else {
                compareToNodePrev = compareToNode;
                compareToNode = compareToNode.next;
            }
        }
        return head;
    }

    static class ListNode {
        public int      val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
