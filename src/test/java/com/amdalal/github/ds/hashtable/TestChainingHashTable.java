package com.amdalal.github.ds.hashtable;

import com.amdalal.github.ds.hashtable.impl.ChainingHashTable;
import org.junit.Assert;
import org.junit.Test;

public class TestChainingHashTable {

    @Test
    public void test1() {
        HashTable<String, String> ht = new ChainingHashTable<>(3);
        Assert.assertTrue(ht.isEmpty());
        Assert.assertEquals(0, ht.size());
        ht.put("K1", "V1");
        ht.put("K2", "V2");
        ht.put("K3", "V3");
        ht.put("K4", "V4");
        Assert.assertEquals("V4", ht.get("K4"));
        Assert.assertEquals("V3", ht.get("K3"));
        Assert.assertEquals("V2", ht.get("K2"));
        Assert.assertEquals("V1", ht.get("K1"));

        Assert.assertEquals(null, ht.get("K5"));
        Assert.assertEquals(4, ht.size());
        Assert.assertFalse(ht.isEmpty());
    }

    @Test(expected = NullPointerException.class)
    public void test2() {
        HashTable<String, String> ht = new ChainingHashTable<>();
        ht.put(null, "V1");
    }

    @Test(expected = NullPointerException.class)
    public void test3() {
        HashTable<String, String> ht = new ChainingHashTable<>();
        ht.get(null);
    }

    /**
     * Test collision
     */
    @Test
    public void test4() {
        HashTable<Key, String> ht = new ChainingHashTable<>();
        Key k1 = new Key(true, 1);
        Key k2 = new Key(true, 2);
        Key k3 = new Key(false, 3);
        ht.put(k1, "V1");
        ht.put(k2, "V2");
        ht.put(k3, "V3");
        ht.put(k3, "V4");
        Assert.assertEquals("V2", ht.get(k2));
        Assert.assertEquals("V1", ht.get(k1));
        Assert.assertEquals("V4", ht.get(k3));
    }
}
