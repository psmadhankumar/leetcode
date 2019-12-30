package io.lc.prep.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given three integer arrays arr1, arr2 and arr3 sorted in strictly increasing order,
 * return a sorted array of only the integers that appeared in all three arrays.
 *  
 * Example 1:
 * Input: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
 * Output: [1,5]
 * Explanation: Only 1 and 5 appeared in the three arrays.
 *  
 * Constraints:
 * 	• 1 <= arr1.length, arr2.length, arr3.length <= 1000
 * 	• 1 <= arr1[i], arr2[i], arr3[i] <= 2000
 *
 * TIPS: One approach is to use the map, for each array and keep counting, when there is three
 * count of each then that appears in all three. There are other approach without using the map, like array pointers.
 */
public class LC1213IntersectionOfThreeSortedArrays {

    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        Map<Integer, Integer> map = new HashMap<>();

        generate(arr1, map);
        generate(arr2, map);
        generate(arr3, map);

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 3) result.add(entry.getKey());
        }
        return result;
    }

    private void generate(int[] arr, Map<Integer, Integer> map) {
        for (int x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
    }


    public List<Integer> arraysIntersection2(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                result.add(arr1[i]);
                i++;
                j++;
                k++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr3[k]) {
                j++;
            } else k++;
        }
        return result;
    }
}


