package io.lc.prep.array.majorityelements;

/**
 * Given an array nums sorted in non-decreasing order, and a number target, return True if and only if target is a majority element.
 * A majority element is an element that appears more than N/2 times in an array of length N.
 *  
 * Example 1:
 * Input: nums = [2,4,5,5,5,5,5,6,6], target = 5
 * Output: true
 * Explanation:
 * The value 5 appears 5 times and the length of the array is 9.
 * Thus, 5 is a majority element because 5 > 9/2 is true.
 * Example 2:
 * Input: nums = [10,100,101,101], target = 101
 * Output: false
 * Explanation:
 * The value 101 appears 2 times and the length of the array is 4.
 * Thus, 101 is not a majority element because 2 > 4/2 is false.
 *  
 * Note:
 * 	1. 1 <= nums.length <= 1000
 * 	2. 1 <= nums[i] <= 10^9
 * 	3. 1 <= target <= 10^9
 *
 * Approach: To use the binary search to find the lower bound of the target value and then use that
 * index + nums.length/2 should contain the same element. Note to check the boundary conditions.
 *
 *
 */
public class LC1150CheckIfNumberIsMajorityElementInSortedArray {

    public boolean isMajorityElement(int[] nums, int target) {

        int lo = 0;
        int hi = nums.length-1;

        while(lo < hi) {
            int mid = lo + (hi - lo) /2;

            if(target == nums[mid]) { hi = mid; }
            else if(target < nums[mid]) { hi = mid-1;}
            else {lo = mid+1;}
        }

        int lowBoundIndex = hi;
        int half = nums.length/2;
        if(lowBoundIndex + half >= nums.length) return false;
        if(nums[lowBoundIndex + half] == target) return true;

        return false;
    }

}