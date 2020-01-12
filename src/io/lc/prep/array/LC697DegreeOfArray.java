package io.lc.prep.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
 *
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 *
 * Example 1:
 * Input: [1, 2, 2, 3, 1]
 * Output: 2
 * Explanation:
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 * Example 2:
 * Input: [1,2,2,3,1,4,2]
 * Output: 6
 * Note:
 *
 * nums.length will be between 1 and 50,000.
 * nums[i] will be an integer between 0 and 49,999.
 *
 * Approach: One option is to use map with element as key and list of indexes as value, then also keep count
 * variable that keeps track of the highest degree. Then loop the map and compare the count to size of list and
 * return the mininum length b/w first and last index.
 *
 */
public class LC697DegreeOfArray {

    public int findShortestSubArray(int[] nums) {

        int count = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], a -> new ArrayList<>()).add(i);
            count = Math.max(count, map.get(nums[i]).size());
        }

        if(count == 1) return 1;

        int len = Integer.MAX_VALUE;
        for(Map.Entry<Integer,List<Integer>> entry : map.entrySet()) {
            int size = entry.getValue().size();

            if(size == count) {
                int firstIndex = entry.getValue().get(0);
                int secondIndex = entry.getValue().get(entry.getValue().size() -1);
                len = Math.min(len, (secondIndex - firstIndex) + 1);
            }
        }

        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
