package com.amdalal.github.ds.hashtable;

class Key {

    private boolean flag;

    private int data;

    public Key(boolean flag, int data) {
        this.flag = flag;
        this.data = data;
    }

    @Override
    public int hashCode() {
        return flag ? Integer.MAX_VALUE : data;
    }

    @Override
    public boolean equals(Object obj) {
        return this.data == ((Key) obj).data;
    }
}
