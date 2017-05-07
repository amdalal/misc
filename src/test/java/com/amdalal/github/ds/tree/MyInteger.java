package com.amdalal.github.ds.tree;

import java.util.Objects;
import java.util.StringJoiner;

public class MyInteger implements TreeEntry, Comparable<MyInteger> {

    private Integer value;

    private static StringJoiner x = new StringJoiner("-");

    public MyInteger(Integer value) {
        this.value = value;
    }

    @Override
    public void visit() {
        x.add(value.toString());
    }

    public void clear() {
        x = new StringJoiner("-");
    }

    public static MyInteger valueOf(int i) {
        return new MyInteger(i);
    }

    public String getOutput() {
        return x.toString();
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
