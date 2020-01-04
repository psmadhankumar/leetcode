package io.lc.prep.subarray;

/**
 * our are given an array of positive integers nums.
 * Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.
 * Example 1:
 * Input: nums = [10, 5, 2, 6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 * Note:
 * • 0 < nums.length <= 50000.
 * • 0 < nums[i] < 1000.
 * • 0 <= k < 10^6.
 *
 * Approach: Two pointer approach. Use left and right and keep doing product for right. When
 * it hits more than k then keep dividing the nums[left] and add the count with (right - left + 1)
 */
public class LC713SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        if(k <=1) return count;

        int product = 1;
        int left = 0;

        for(int right = 0; right < nums.length; right++) {
            product *= nums[right];

            while(product >= k && left < nums.length) {
                product = product / nums[left++];
            }
            count = count + right - left + 1;
        }

        return count;
    }

}
