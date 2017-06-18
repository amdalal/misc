package com.amdalal.github.ds.list;

import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Test;

import com.amdalal.github.BaseTest;
import com.amdalal.github.ds.list.impl.SinglyLinkedList;

public class TestSinglyLinkedList extends BaseTest {

    @Test
    public void test1() {
        LinkedList<Integer> list = new SinglyLinkedList<>();
        list.pushFront(3);
        list.pushFront(2);
        list.pushFront(1);
        Assert.assertEquals(Integer.valueOf(1), list.getFront());
        Assert.assertEquals(3, list.size());
        Assert.assertEquals(false, list.isEmpty());
        Assert.assertEquals(Integer.valueOf(1), list.elementAt(0));
        Assert.assertEquals(Integer.valueOf(2), list.elementAt(1));
        Assert.assertEquals(Integer.valueOf(3), list.elementAt(2));
    }

    @Test
    public void test2() {
        LinkedList<Integer> list = new SinglyLinkedList<>();
        Assert.assertEquals(true, list.isEmpty());
    }

    @Test
    public void test3() {
        LinkedList<Integer> list = new SinglyLinkedList<>();
        list.pushFront(3);
        Assert.assertEquals(Integer.valueOf(3), list.getFront());
    }

    @Test
    public void test4() {
        LinkedList<Integer> list = new SinglyLinkedList<>();
        list.pushFront(1);
        Assert.assertEquals(Integer.valueOf(1), list.pushFront(2));
    }

    @Test
    public void test5() {
        LinkedList<Integer> list = new SinglyLinkedList<>();
        Integer element = list.pushBack(1);
        Assert.assertEquals(Integer.valueOf(1), list.getFront());
        Assert.assertEquals(element, null);
    }

    @Test
    public void test6() {
        LinkedList<Integer> list = new SinglyLinkedList<>();
        list.pushBack(1);
        list.pushBack(2);
        Integer element = list.pushBack(3);
        Assert.assertEquals(Integer.valueOf(3), list.getBack());
        Assert.assertEquals(Integer.valueOf(2), element);
    }

    @Test
    public void test7() {
        LinkedList<Integer> list = new SinglyLinkedList<>();
        list.pushFront(3);
        list.pushFront(2);
        list.pushFront(1);
        Assert.assertEquals(list.popFront(), Integer.valueOf(1));
        Assert.assertEquals(2, list.size());
        Assert.assertEquals(Integer.valueOf(2), list.popFront());
        Assert.assertEquals(1, list.size());
    }

    @Test(expected = NoSuchElementException.class)
    public void test8() {
        new SinglyLinkedList<>().getFront();
    }

    @Test(expected = NoSuchElementException.class)
    public void test9() {
        new SinglyLinkedList<>().getBack();
    }

    @Test(expected = NoSuchElementException.class)
    public void test10() {
        new SinglyLinkedList<>().popFront();
    }
}
