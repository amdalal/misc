package com.amdalal.github.ds.list.impl;

import com.amdalal.github.ds.list.LinkedList;

import java.util.NoSuchElementException;

public class SinglyLinkedList<T> implements LinkedList<T> {

    private Node<T> head;

    private int size = 0;

    @Override
    public T pushFront(T element) {
        Node<T> newHead = new Node<>();
        newHead.data = element;
        T oldHeadData = null;
        if (!isEmpty()) {
            newHead.next = head;
            oldHeadData = head.data;
        }
        head = newHead;
        size++;
        return oldHeadData;
    }

    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.data;
    }

    @Override
    public T pushBack(T element) {
        Node<T> newTail = new Node<>();
        newTail.data = element;
        T oldTailData = null;
        Node<T> currentTail = head;
        if (currentTail != null) {
            while (currentTail.next != null) {
                currentTail = currentTail.next;
            }
            oldTailData = currentTail.data;
            currentTail.next = newTail;
        } else {
            head = newTail;
        }
        size++;
        return oldTailData;
    }

    @Override
    public T getBack() {
        Node<T> tail = head;
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        while (tail.next != null) {
            tail = tail.next;
        }
        return tail.data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T elementAt(int index) {
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            if (current != null) {
                current = current.next;
            } else {
                break;
            }
        }
        return current == null ? null : current.data;
    }

    @Override
    public T popFront() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T oldHeadValue = head.data;
        head = head.next;
        size--;
        return oldHeadValue;
    }

    private static class Node<T> {
        private T       data;
        private Node<T> next;
    }
}


