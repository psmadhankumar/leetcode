package io.lc.prep.design;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 *
 * Example:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */
public class LC155MinStack {

    Stack<Node> stack = null;

    /** initialize your data structure here. */
    public LC155MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {

        if(stack.isEmpty()) {
            stack.push(new Node(x, x));
        } else {
            int currentMin = Math.min(stack.peek().min, x);
            stack.push(new Node(x, currentMin));
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().min;
    }

    private class Node {
        int val;
        int min;

        public Node(int v, int m) {
            val = v;
            min = m;
        }
    }
}
