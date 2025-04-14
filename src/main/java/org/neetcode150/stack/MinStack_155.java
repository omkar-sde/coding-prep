package org.neetcode150.stack;

import java.util.*;
public class MinStack_155 {
    /*
        Problem Statement: Custom stack class that has function to return min of the stack
        Intuition: Maintain a min value stack
        Time Complexity: O(1)
        Space Complexity: O(n)
     */
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack_155() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()) minStack.push(val);
        else minStack.push(Math.min(val, minStack.peek()));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack_155 minStack = new MinStack_155();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("Current Min: " + minStack.getMin()); // Expected: -3

        minStack.pop();
        System.out.println("Top Element: " + minStack.top());     // Expected: 0
        System.out.println("Current Min: " + minStack.getMin());  // Expected: -2

        minStack.push(-10);
        System.out.println("Current Min: " + minStack.getMin());  // Expected: -10
    }

}
