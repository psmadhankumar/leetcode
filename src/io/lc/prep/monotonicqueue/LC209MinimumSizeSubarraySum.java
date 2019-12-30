package io.lc.prep.monotonicqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray
 * of which the sum ≥ s. If there isn't one, return 0 instead.
 *
 * Example:
 *
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 *
 * Approach: Both monotonic approach and regular, also binary search approach is possible.
 */
public class LC209MinimumSizeSubarraySum {


    /**
     * Below method uses the monotonic approach of queues, although not the monotonic queue properties
     * (increasing or decreasing)
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLenMonotonicQueue(int s, int[] nums) {

        int len = Integer.MAX_VALUE;
        Deque<Integer> deque = new ArrayDeque<>();
        int currentSum = 0;

        for(int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            deque.addLast(i);

            while(!deque.isEmpty() && currentSum >= s) {
                len = Math.min(len, deque.size());
                currentSum = currentSum - nums[deque.pollFirst()];
            }
        }

        return len == Integer.MAX_VALUE ? 0 : len;
    }


    public int minSubArrayLenRegular(int s, int[] nums) {
        int left = 0;
        // TODO base conditions

        int current = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++){
            current += nums[i];

            while(current >= s) {
                System.out.println("s:" + current);
                min = Math.min(min, i - left + 1);
                current = current - nums[left];
                left++;
            }
        }
        return min != Integer.MAX_VALUE ? min : 0 ;
    }

}
