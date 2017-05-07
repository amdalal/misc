package com.amdalal.github.ds.tree;

import java.util.Objects;

import com.amdalal.github.ResultHolder;
import com.amdalal.github.ds.Visitable;

public class MyInteger implements Visitable, Comparable<MyInteger> {

    private Integer value;

    public MyInteger(Integer value) {
        this.value = value;
    }

    @Override
    public void visit() {
        ResultHolder.append(value.toString());
    }

    public static MyInteger valueOf(int i) {
        return new MyInteger(i);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        MyInteger myInteger = (MyInteger) o;
        return Objects.equals(value, myInteger.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(MyInteger o) {
        return this.value.compareTo(o.value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
