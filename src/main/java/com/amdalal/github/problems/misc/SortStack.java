package com.amdalal.github.problems.misc;

import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {

    }

    public static Stack<Integer> sort(Stack<Integer> inputStack) {
        if (inputStack == null) {
            throw new IllegalArgumentException("input stack cannot be null");
        }
        if (inputStack.size() <= 1) {
            return inputStack;
        }
        Stack<Integer> sortedStack = new Stack<>();
        Integer currentMin = Integer.MIN_VALUE;
        while (!inputStack.isEmpty()) {
            Integer element = inputStack.pop();
            if (element < currentMin) {
                sortedStack.push(element);
                currentMin = element;
            } else {
                pushElementToSortedStack(element, sortedStack);
            }
        }
        return sortedStack;
    }

    private static void pushElementToSortedStack(Integer element, Stack<Integer> sortedStack) {
        Stack<Integer> tempStack = new Stack<>();
        while (!sortedStack.isEmpty() && sortedStack.peek() < element) {
            tempStack.push(sortedStack.pop());
        }
        sortedStack.push(element);
        while (!tempStack.isEmpty()) {
            sortedStack.push(tempStack.pop());
        }
    }

}
