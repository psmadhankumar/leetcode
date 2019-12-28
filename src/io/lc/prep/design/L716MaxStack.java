package io.lc.prep.design;

import java.util.Stack;

/**
 * Design a max stack that supports push, pop, top, peekMax and popMax.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Remove the element on top of the stack and return it.
 * top() -- Get the element on the top.
 * peekMax() -- Retrieve the maximum element in the stack.
 * popMax() -- Retrieve the maximum element in the stack, and remove it. If you find more than one maximum elements, only remove the top-most one.
 * Example 1:
 * MaxStack stack = new MaxStack();
 * stack.push(5);
 * stack.push(1);
 * stack.push(5);
 * stack.top(); -> 5
 * stack.popMax(); -> 5
 * stack.top(); -> 1
 * stack.peekMax(); -> 5
 * stack.pop(); -> 1
 * stack.top(); -> 5
 * Note:
 * -1e7 <= x <= 1e7
 * Number of operations won't exceed 10000.
 * The last four operations won't be called when stack is empty.
 */
public class L716MaxStack {


    Stack<Node> stack = null;
    /** initialize your data structure here. */
    public L716MaxStack() {
        stack = new Stack<>();
    }

    public void push(int x) {

        if(stack.isEmpty()) {
            stack.push(new Node(x,x));
        } else {
            int currentMax = Math.max(stack.peek().max, x);
            stack.push(new Node(x, currentMax));
        }
    }

    public int pop() {
        return stack.pop().val;
    }

    public int top() {
        return stack.peek().val;
    }

    public int peekMax() {
        return stack.peek().max;
    }

    public int popMax() {
        Stack<Node> temp = new Stack();
        int currentMax = stack.peek().max;

        while(!stack.isEmpty()) {
            if(stack.peek().val == currentMax) {
                stack.pop();
                break;
            }
            else {
                temp.push(stack.pop());
            }
        }

        while(!temp.isEmpty()) {
            if(stack.isEmpty()) {
                int val = temp.pop().val;
                stack.push(new Node(val, val));
            } else {
                int newMax = Math.max(stack.peek().max, temp.peek().val);
                temp.peek().max = newMax;
                stack.push(temp.pop());
            }
        }

        return currentMax;
    }

    private class Node {
        int val;
        int max;

        public Node(int v, int m) {
            val = v;
            max = m;
        }
    }
}
