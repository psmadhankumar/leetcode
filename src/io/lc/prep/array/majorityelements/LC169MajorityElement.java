package io.lc.prep.array.majorityelements;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 *
 *
 * Approach: (1) Use the sorting and then the middle element will be majority as here, asked for n/2 as the majority.
 * (2) Or by using Boyer-Moore Voting Algorithm: Which keeps counting for each same element, and decrements if
 * Ith element is not that element. And if the count became zero, then reset the element to current ith position.
 *
 *
 */
public class LC169MajorityElement {
    public int majorityElement(int[] nums) {

        int count = 0;
        Integer x = null;
        for(int n : nums) {
            x = x == null ? n : x;

            count += x == n ? 1 : -1;
            if(count == 0) x = null;
        }

        /*
        Using sort problem:
            Arrays.sort(nums);
            return nums[nums.length/2];
        */
        return x;
    }
}
