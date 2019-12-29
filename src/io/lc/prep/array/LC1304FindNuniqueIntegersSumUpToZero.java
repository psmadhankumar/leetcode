package io.lc.prep.array;

/**
 * Given an integer n, return any array containing n unique integers such that they add up to 0.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 5
 * Output: [-7,-1,1,3,4]
 * Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
 * Example 2:
 *
 * Input: n = 3
 * Output: [-1,0,1]
 * Example 3:
 *
 * Input: n = 1
 * Output: [0]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 1000
 *
 * Approach: following is not great, but to use single loop with left and right and have a variable to add positive and negative.
 */
public class LC1304FindNuniqueIntegersSumUpToZero {

    public int[] sumZero(int n) {
        if(n == 1) return new int[] {0};
        if(n == 2) return new int[] {1, -1};

        int[] result = new int[n];
        int half = n / 2;

        for(int i = 1; i <= half; i++)  {
            result[i-1] = -1 * i;
        }
        int i = half;
        int j = half;
        if(n % 2 == 1) { i = half + 1;}

        for(; i < n; i++) {
            result[i] = j;
            j--;
        }

        return result;
    }
}
