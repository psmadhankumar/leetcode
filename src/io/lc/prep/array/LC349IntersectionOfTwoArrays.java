package io.lc.prep.array;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Note:
 *
 * Each element in the result must be unique.
 * The result can be in any order.
 *
 * Approach : One set would have been sufficient, then 2nd use the same array to pass and get the result.
 */
public class LC349IntersectionOfTwoArrays {


    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> first = IntStream.of(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> second= IntStream.of(nums2).boxed().collect(Collectors.toSet());

        int firstLen = first.size();
        int secondLen= second.size();

        if(firstLen > secondLen) {
            return intersect(second, first);
        } else {
            return intersect(first, second);
        }
    }

    private int[] intersect(Set<Integer> first, Set<Integer> second) {
        Set<Integer> result = new HashSet<>();

        for(int x : first) {
            if(second.contains(x)) {
                result.add(x);
            }
        }

        return result.stream().mapToInt(i->i).toArray();
    }
}
