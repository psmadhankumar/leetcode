package io.lc.prep.monotonicqueue;

import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 *
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 *
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 *
 * Example:
 *
 * Input: [2,1,5,6,2,3]
 * Output: 10
 *
 * Approach:
 *
 *  This problem also can be solved using monotonic properties. Such that, using stack with the property of "finding nearest lower".
 * 	1. That means, if coming height is lesser than top-of-stack, then that stack's-top-element can be removed.
 * 	2. And when popping from stack, also calculate the area,
 * 	3. such that, stack.pop() * (current-loop-index  - stack[top -1] (which element after popping) - 1(this
 * 	is to reduce the index size). And, since we are using stack[top -1] element, have the stack initialized with "-1"
 * 	4. Finally, when there is element remaining in the stack, then keep popping until the last-but-one (which is -1),
 * 	and keep calculating the area as mentioned above.
 */
public class LC84LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        /*
         * The problem is all about finding the previous minimum
         * and calculate the rectangle on it.
         */
        if(heights.length == 0) return 0;

        //keep track of the lowest indexes
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int max = 0;
        for(int i = 0; i < heights.length; i++) {

            //As long as height in stack is greater than coming height coming in
            //then, calculate the current area. Because, the element coming
            //in will be lowest border for any incoming elements
            while(stack.peek() != -1 && heights[stack.peek()] > heights[i]) {
                int element = heights[stack.pop()];
                //Formula for calculating area is
                // current-stack-element-that-is-poped-from-stack * (current-index - stack's-peek-element -  reduce the right index)
                int area =  element * (i - stack.peek() - 1);

                max = Math.max(max, area);
            }

            stack.push(i);
        }

        //Finally, for the rest of the indexes that are sitting in stack
        //calculate the area
        while(stack.peek() != -1) {
            int area = heights[stack.pop()] * ( heights.length - stack.peek() -1);
            max = Math.max(max, area);
        }

        return max;
    }

}
