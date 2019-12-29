package io.lc.prep.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.
 *
 * Notice that you can not jump outside of the array at any time.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [4,2,3,0,3,1,2], start = 5
 * Output: true
 * Explanation:
 * All possible ways to reach at index 3 with value 0 are:
 * index 5 -> index 4 -> index 1 -> index 3
 * index 5 -> index 6 -> index 4 -> index 1 -> index 3
 * Example 2:
 *
 * Input: arr = [4,2,3,0,3,1,2], start = 0
 * Output: true
 * Explanation:
 * One possible way to reach at index 3 with value 0 is:
 * index 0 -> index 4 -> index 1 -> index 3
 * Example 3:
 *
 * Input: arr = [3,0,2,1,2], start = 2
 * Output: false
 * Explanation: There is no way to reach at index 1 with value 0.
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 5 * 10^4
 * 0 <= arr[i] < arr.length
 * 0 <= start < arr.length
 *
 * Approach: Use the bfs to solve
 */
public class LC1306JumpGame3 {

    public boolean canReach(int[] arr, int start) {
        //keep track of visited indexes
        boolean[] visited = new boolean[arr.length];

        //keep the index to be visited in the queue
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()) {

            int currentIndex = queue.poll();
            visited[currentIndex] = true;

            //then we found 0 value cell, return true
            if(arr[currentIndex] == 0) return true;

            //calculate the forward and backward index
            int forwardIndex = currentIndex + arr[currentIndex];
            int backwardIndex= currentIndex - arr[currentIndex];

            if(forwardIndex < arr.length && !visited[forwardIndex]) {queue.add(forwardIndex); }
            if(backwardIndex >= 0 && !visited[backwardIndex]){queue.add(backwardIndex);}
        }

        //meaning we dont reach the zero index and we cannot move using any cells from starting location
        return false;
    }
}
