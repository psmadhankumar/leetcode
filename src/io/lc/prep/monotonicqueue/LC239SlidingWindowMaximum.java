package io.lc.prep.monotonicqueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
 *
 * Example:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 *
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
 *
 * Follow up:
 * Could you solve it in linear time?
 * Approach:
 * This problem can be solved using Monotonic queue, which is to use either queue or stack and based on constraint,
 * have increasing or decreasing queue/stack. Thus, will allow the problem to be solved in liner time complexity.
 *
 * In this problem,
 * 	1. Define Deque to handle polling-from-first when queue goes more than given window-size
 * 	2. And, other condition, is if poll-from-first when if queue's first element is greater than i - k
 *  3. Lastly, when current last-element in queue is lesser than incoming element, then keep poping the
 *  last element so increasing-monotonic-queue property is satisfied.
 *
 */
public class LC239SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();

        List<Integer> answer = new ArrayList<>();
        int count = 0;
        for(int i = 0; i < nums.length; i++) {

            //if size is k then remove the left most element
            if(deque.size() >= k) {
                deque.pollFirst();
            }

            //also if queue's first element is greater than i - k then remove it.
            if(!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }

            //if size is less then k, then compare from right of queue and keep poping when incoming is greater than one inside
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.addLast(i);
            count++;

            if(count >= k) {
                answer.add(nums[deque.peekFirst()]);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
