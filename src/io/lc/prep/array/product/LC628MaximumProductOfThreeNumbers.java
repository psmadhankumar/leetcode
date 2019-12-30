package io.lc.prep.array.product;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an integer array, find three numbers whose product is maximum and output the maximum product.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: 6
 *
 *
 * Example 2:
 *
 * Input: [1,2,3,4]
 * Output: 24
 *
 *
 * Note:
 *
 * The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
 * Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
 *
 * Approach: (1) Use min, max priority queue or (2) sort and take max'es and min from it
 *
 */
public class LC628MaximumProductOfThreeNumbers {
    public int maximumProduct(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for(int x : nums) {
            minHeap.add(x);
            maxHeap.add(x);
        }

        int max1 = maxHeap.poll();
        int max2 = maxHeap.poll();
        int max3 = maxHeap.poll();

        int min1 = minHeap.poll();
        int min2 = minHeap.poll();

        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }

}
