package io.lc.prep.monotonicqueue;

import java.util.Stack;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 *
 * Example:
 *
 * Input:
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"],
 *   ["1","0","0","1","0"]
 * ]
 * Output: 6
 *
 * Approach: The approach as in finding the rectangle in histogram. For each row and each time, keep adding the
 * row into single row and do the histogram approach. One important condition, when adding, if the element is zero,
 * then its like "no bar" so even if previous row had some value, it will be treated as zero. And
 * for each row call the histogram and keep comparing to current rectangle max.
 */
public class LC85MaximalRectangle {


    public int maximalRectangle(char[][] matrix) {
        int max = 0;
        if(matrix.length == 0) return max;

        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        int dp[] = new int[colLen];

        //1. loop through each cell and call rectangle check for each row (not for each column)
        for (int r = 0; r < rowLen; r++) {
            for(int c = 0; c< colLen; c++) {
                /*2. build the base row
                 * 1st iteration => dp => 1 0 1 0 0
                 * 2nd iteration => dp => 2 0 2 1 1
                 * 3rd iteration => dp => 3 1 3 2 2
                 * 4th iteration => dp => 4 0 0 3 0
                 */
                dp[c] = matrix[r][c] == '1' ? dp[c] + 1 : 0;
            }

            //3. Check the size of rectangle for each accumalated row
            int rowRectangle = rectangleInRow(dp);

            //4.update the max
            max = Math.max(max, rowRectangle);
        }

        return max;
    }

    private int rectangleInRow(int[] array) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int max = 0;
        for(int i = 0; i < array.length; i++) {
            while(stack.peek() != -1 && array[stack.peek()] > array[i]) {
                int area = array[stack.pop()] * (i - stack.peek() -1);
                max = Math.max(max, area);
            }
            stack.push(i);
        }

        while(stack.peek() != -1) {
            int area = array[stack.pop()] * (array.length - stack.peek() -1);
            max = Math.max(max, area);
        }

        return max;
    }
}
