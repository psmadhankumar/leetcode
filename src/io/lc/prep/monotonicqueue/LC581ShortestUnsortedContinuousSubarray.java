package io.lc.prep.monotonicqueue;

import java.util.Stack;

/**
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.
 * You need to find the shortest such subarray and output its length.
 * Example 1:
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 * Note:
 * 	1. Then length of the input array is in range [1, 10,000].
 * 	2. The input array may contain duplicates, so ascending order here means <=.
 *
 *
 * Approach: This is monotonic-queue, however, important to be taken care is first left and right side. First do
 * from left and keep the increasing order queue and whenever poping the element, have the minimum of the index.
 * And reverse for the back to front.
 *
 */
public class LC581ShortestUnsortedContinuousSubarray {

    public int findUnsortedSubarray(int[] nums) {
        int low = findLowest(nums);
        int high = findLargest(nums);

        //System.out.println("low:" + low);
        //System.out.println("high:" + high);

        return high - low > 0 ? high - low + 1 : 0;
    }


    private int findLargest(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int highest = 0;
        for(int i = nums.length-1; i >= 0; i--) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                highest = Math.max(highest,stack.pop());
            }
            stack.push(i);
        }

        return highest;
    }

    private int findLowest(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int lowest = nums.length;
        for(int i = 0; i < nums.length; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                lowest = Math.min(lowest,stack.pop());
            }

            stack.push(i);
        }

        return lowest;
    }

}
