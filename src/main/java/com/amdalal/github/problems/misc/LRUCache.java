package com.amdalal.github.problems.misc;//Implement a cache with LRU eviction policy

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private Map<String, Entry> cache;
    private Node               head = null;
    private Node               tail = null;
    private int                size;

    public LRUCache(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("size must be greater than 0");
        }
        this.size = size;
        this.cache = new HashMap<>(size);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(14);
        lruCache.put("1", "A");
        lruCache.put("2", "B");
        lruCache.put("3", "C");
        lruCache.put("4", "D");
        lruCache.put("5", "E");
        System.out.println("==============================");
        System.out.println(lruCache.head);
        System.out.println(lruCache.cache);
        System.out.println("==============================");
        System.out.println("Invoking get(4)");
        lruCache.get("4");
        System.out.println(lruCache.head);
        System.out.println(lruCache.cache);
        System.out.println("==============================");
        System.out.println("Invoking get(3)");
        lruCache.get("3");
        System.out.println(lruCache.head);
        System.out.println(lruCache.cache);
        System.out.println("==============================");
        System.out.println("Invoking get(5)");
        lruCache.get("5");
        System.out.println(lruCache.head);
        System.out.println(lruCache.cache);
        System.out.println("==============================");
        System.out.println("Invoking put(2)");
        lruCache.put("2", "B1");
        System.out.println(lruCache.head);
        System.out.println(lruCache.cache);
        System.out.println("==============================");
    }

    public Object put(String key, Object value) {
        Entry entry = cache.get(key);
        Object oldValue = null;
        if (entry != null) {
            oldValue = entry.value;
            entry.value = value;
            deleteNode(entry.node);
        } else {
            if (cache.size() >= size) {
                cache.remove(tail.data);
                deleteNode(tail);
            }
            entry = new Entry(key, value);
        }
        assignNewHead(key, entry);
        cache.put(key, entry);
        return oldValue;
    }

    public Object get(String key) {
        Object value = null;
        Entry entry = cache.get(key);
        if (entry != null) {
            value = entry.value;
            Node keyNode = entry.node;
            deleteNode(keyNode);
            assignNewHead(key, entry);
        }
        return value;
    }

    private void assignNewHead(String key, Entry entry) {
        Node newHead = new Node(key);
        entry.node = newHead;
        newHead.next = head;
        if (head != null) {
            head.previous = newHead;
        } else {
            tail = newHead;
        }
        head = newHead;
    }

    private void deleteNode(Node node) {
        if (node.previous != null) {
            node.previous.next = node.next;
        } else {
            head = node.next;
        }
        if (node.next != null) {
            node.next.previous = node.previous;
        } else {
            tail = node.previous;
        }
    }

    private class Entry {
        private Node   node;
        private Object value;

        private Entry(String key, Object value) {
            this.node = new Node(key);
            this.value = value;
        }

        @Override
        public String toString() {
            return node.data + "|" + value;
        }
    }

    private class Node {
        private String data;
        private Node   next;
        private Node   previous;

        private Node(String data) {
            this.data = data;
        }

        @Override
        public String toString() {
            Node n = this;
            StringBuilder b = new StringBuilder();
            while (n != null) {
                b.append(n.data).append(" -> ");
                n = n.next;
            }
            return b.toString();
        }
    }
}
