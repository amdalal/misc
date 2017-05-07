package com.amdalal.github.ds.hashtable;

public interface HashTable<K,V> {

    V put(K key, V value);

    V get(K key);

    int size();

    boolean isEmpty();
}
