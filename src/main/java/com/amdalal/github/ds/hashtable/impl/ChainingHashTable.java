package com.amdalal.github.ds.hashtable.impl;

import com.amdalal.github.ds.list.LinkedList;
import com.amdalal.github.ds.hashtable.HashTable;
import com.amdalal.github.ds.list.impl.SinglyLinkedList;

public class ChainingHashTable<K, V> implements HashTable<K, V> {

    private static final int    INITIAL_CAPACITY = 8;
    private static final double LOAD_FACTOR      = 0.75D;

    private int                 size;
    private LinkedList<Entry>[] data;
    private double              loadFactor;

    public ChainingHashTable() {
        this(INITIAL_CAPACITY, LOAD_FACTOR);
    }

    public ChainingHashTable(int initialCapacity) {
        this(initialCapacity, LOAD_FACTOR);
    }

    public ChainingHashTable(int initialCapacity, double loadFactor) {
        this.data = new SinglyLinkedList[initialCapacity];
        this.loadFactor = loadFactor;
    }

    public V put(K key, V value) {
        if (key == null) {
            throw new NullPointerException("key cannot be null");
        }
        V currentValue = null;
        if (size() >= data.length * loadFactor) {
            resize();
        }
        int targetIndex = key.hashCode() % data.length;
        LinkedList<Entry> listAtTargetIndex = data[targetIndex];
        if (listAtTargetIndex == null) {
            listAtTargetIndex = new SinglyLinkedList<>();
            data[targetIndex] = listAtTargetIndex;
        }
        for (int i = 0; i < listAtTargetIndex.size(); i++) {
            Entry<K, V> e = listAtTargetIndex.elementAt(i);
            if (e != null && e.getKey().equals(key)) {
                currentValue = e.getValue();
                e.setValue(value);
                break;
            }
        }
        if (currentValue == null) {
            data[targetIndex].pushBack(new Entry<K, V>(key, value));
            currentValue = value;
        }
        size++;
        return currentValue;
    }

    private void resize() {
        int newCapacity = data.length * 2;
        LinkedList<Entry>[] newData = new LinkedList[newCapacity];
        for (LinkedList<Entry> listAtIndex : data) {
            if (listAtIndex != null) {
                for (int j = 0; j < listAtIndex.size(); j++) {
                    Entry<K, V> e = listAtIndex.elementAt(j);
                    int targetIndex = e.getKey().hashCode() % newData.length;
                    if (newData[targetIndex] == null) {
                        newData[targetIndex] = new SinglyLinkedList<>();
                    }
                    newData[targetIndex].pushBack(e);
                }
            }
        }
        data = newData;
    }

    @Override
    public V get(K key) {
        if (key == null) {
            throw new NullPointerException("key cannot be null");
        }
        V output = null;
        if (!isEmpty()) {
            int targetIndex = key.hashCode() % data.length;
            LinkedList<Entry> listAtIndex = data[targetIndex];
            if (listAtIndex != null) {
                for (int i = 0; i < listAtIndex.size(); i++) {
                    Entry<K, V> e = listAtIndex.elementAt(i);
                    if (e.getKey().equals(key)) {
                        output = e.getValue();
                        break;
                    }
                }
            }
        }
        return output;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    private class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }
    }
}
