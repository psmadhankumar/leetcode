package io.lc.prep.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Note:
 *
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 *
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 *
 * Approach: 1. Have one map to count for one array and then pass that one array and keep checking the 2nd array and add it.
 * If one array is very big, then built the map for smaller array.
 *
 * Below is not good solution, its better to have only once map generate and deal the adding the result.
 */
public class LC350IntersectionOfTwoArraysII {

    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            int n1Len = nums1.length;
            int n2Len = nums2.length;

            Map<Integer, Integer> map = null;
            if(n1Len > n2Len) {
                map = generateMap(nums1);
                return intersect(nums2, map);
            } else {
                map = generateMap(nums2);
                return intersect(nums1, map);
            }
        }

        private int[] intersect(int[] nums, Map<Integer, Integer> map) {
            List<Integer> result = new ArrayList<>();

            for(int num : nums) {
                Integer v = map.get(num);
                if(v != null && v > 0) {
                    result.add(num);
                    map.put(num, map.get(num) - 1);
                }
            }

            return result.stream().mapToInt(i->i).toArray();
        }

        private Map<Integer, Integer> generateMap(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            return map;
        }


    }
}
