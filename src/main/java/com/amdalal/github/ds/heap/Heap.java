package com.amdalal.github.ds.heap;

public class Heap<T extends Comparable<? super T>> {

    public enum Type {
        MIN, MAX
    }

    private int capacity;

    private Object[] data;

    private int size;

    private Type type;

    public Heap(int capacity, Type type) {
        this.capacity = capacity;
        this.data = new Object[capacity + 1];
        this.type = type;
    }

    public Heap(T[] data, Type type) {
        Object[] thisData = new Object[data.length + 1];
        System.arraycopy(data, 0, thisData, 1, data.length);
        this.data = thisData;
        this.capacity = data.length;
        this.type = type;
        for (int i = this.data.length / 2; i >= 1; i--) {
            shiftDown(i);
        }
        size = data.length;
    }

    public int insert(T key) {
        int leafIdx = findLeaf();
        if (leafIdx != -1) {
            data[leafIdx] = key;
            shiftUp(leafIdx);
            size++;
        }
        return -1;
    }

    private int findLeaf() {
        for (int i = capacity; i >= 1; i--) {
            if (data[i] == null) {
                return i;
            }
        }
        return -1;
    }

    private void shiftUp(int index) {
        int parentIdx = index / 2;
        boolean comparisionResult = false;
        if (data[parentIdx] != null) {
            comparisionResult = type == Type.MAX ? ((T) data[parentIdx]).compareTo((T) data[index]) <= 0 : ((T) data[parentIdx]).compareTo((T) data[index]) > 0;
        }
        if (parentIdx != 0 && (data[parentIdx] == null || comparisionResult)) {
            swap(index, parentIdx);
            shiftUp(parentIdx);
        }
    }

    private void shiftDown(int index) {
        int leftChildIdx = getLeftChildIdx(index);
        int rightChildIdx = getRightChildIdx(index);
        int theOne = -1;
        if (leftChildIdx != -1 && rightChildIdx != -1) {
            boolean isLeftChildGreater = ((T) data[leftChildIdx]).compareTo((T) data[rightChildIdx]) > 0;
            int candidate = (type == Type.MAX && isLeftChildGreater || type == Type.MIN && !isLeftChildGreater) ? leftChildIdx : rightChildIdx;
            boolean isCandidateGreater = ((T) data[candidate]).compareTo((T) data[index]) > 0;
            if (type == Type.MAX && isCandidateGreater || type == Type.MIN && !isCandidateGreater) {
                theOne = candidate;
            }
        } else if (leftChildIdx != -1) {
            boolean isLeftChildGreater = ((T) data[leftChildIdx]).compareTo((T) data[index]) > 0;
            if (type == Type.MAX && isLeftChildGreater || type == Type.MIN && !isLeftChildGreater) {
                theOne = leftChildIdx;
            }
        }
        if (theOne != -1) {
            swap(index, theOne);
            shiftDown(theOne);
        }
    }

    private int getRightChildIdx(int index) {
        int rightChildIdx = index * 2 + 1;
        if (rightChildIdx <= capacity && data[rightChildIdx] != null) {
            return rightChildIdx;
        }
        return -1;
    }

    private int getLeftChildIdx(int index) {
        int leftChildIdx = index * 2;
        if (leftChildIdx <= capacity && data[leftChildIdx] != null) {
            return leftChildIdx;
        }
        return -1;
    }

    private void swap(int fromIndex, int toIndex) {
        Object temp = data[fromIndex];
        data[fromIndex] = data[toIndex];
        data[toIndex] = temp;
    }

    public final int getSize() {
        return size;
    }

    public final int getCapacity() {
        return capacity;
    }

    public T getRoot() {
        return (T) data[1];
    }

    public T extractRoot() {
        int leafIdx = -1;
        for (int i = capacity; i >= 1; i--) {
            if (data[i] != null) {
                leafIdx = i;
                break;
            }
        }
        T output = (T) data[1];
        data[1] = data[leafIdx];
        data[leafIdx] = null;
        shiftDown(1);
        size--;
        return output;
    }
}
