package io.lc.prep.design;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * Implement the following operations of a stack using queues.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * Example:
 *
 * MyStack stack = new MyStack();
 *
 * stack.push(1);
 * stack.push(2);
 * stack.top();   // returns 2
 * stack.pop();   // returns 2
 * stack.empty(); // returns false
 * Notes:
 *
 * You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 * You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 *
 * TODO: There is better way to do this, just by using the recursive inserting the element at front during push!
 * */
public class LC225ImplementStackUsingQueues {

    Queue<Integer> topQueue = null;
    Queue<Integer> regularQueue = null;

    /** Initialize your data structure here. */
    public LC225ImplementStackUsingQueues() {
        topQueue = new LinkedList<>();
        regularQueue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(topQueue.isEmpty()) {
            topQueue.offer(x);
        }
        else {
            regularQueue.offer(topQueue.poll());
            topQueue.offer(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int x = topQueue.poll();

        Queue<Integer> temp = new LinkedList<>();
        while(!regularQueue.isEmpty() && regularQueue.size() > 1) {
            temp.offer(regularQueue.poll());
        }
        if(!regularQueue.isEmpty()) topQueue.offer(regularQueue.poll());
        while(!temp.isEmpty()) { regularQueue.add(temp.poll()); }

        return x;
    }

    /** Get the top element. */
    public int top() {
        return topQueue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return topQueue.isEmpty();
    }
}