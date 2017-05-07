package com.amdalal.github.ds.queue.impl;

import com.amdalal.github.ds.queue.Queue;
import com.amdalal.github.ds.stack.impl.ArrayStack;
import com.amdalal.github.ds.stack.Stack;

public class TwoStackQueue<T> implements Queue<T> {

    private Stack<T> enqueueStack;

    private Stack<T> dequeueStack;

    public TwoStackQueue(int capacity) {
        enqueueStack = new ArrayStack<T>(capacity);
        dequeueStack = new ArrayStack<T>(capacity);
    }

    @Override
    public T enqueue(T element) {
        if (enqueueStack.isEmpty() && !dequeueStack.isEmpty()) {
            transferAll(dequeueStack, enqueueStack);
        }
        return enqueueStack.push(element);
    }

    @Override
    public T dequeue() {
        if (!enqueueStack.isEmpty() && dequeueStack.isEmpty()) {
            transferAll(enqueueStack, dequeueStack);
        }
        return dequeueStack.pop();
    }

    private void transferAll(Stack<T> fromStack, Stack<T> toStack) {
        if (!toStack.isEmpty() || fromStack.isEmpty()) {
            throw new IllegalStateException();
        }
        int fromStackSize = fromStack.size();
        for (int i = 0; i < fromStackSize; i++) {
            toStack.push(fromStack.pop());
        }
    }

    @Override
    public boolean isEmpty() {
        return enqueueStack.isEmpty() && dequeueStack.isEmpty();
    }
}




