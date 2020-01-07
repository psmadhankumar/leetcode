package io.lc.prep.dp;

/**
 * Given a string s. In one step you can insert any character at any index of the string.
 * Return the minimum number of steps to make s palindrome.
 * A Palindrome String is one that reads the same backward as well as forward.
 *  
 * Example 1:
 * Input: s = "zzazz"
 * Output: 0
 * Explanation: The string "zzazz" is already palindrome we don't need any insertions.
 * Example 2:
 * Input: s = "mbadm"
 * Output: 2
 * Explanation: String can be "mbdadbm" or "mdbabdm".
 * Example 3:
 * Input: s = "leetcode"
 * Output: 5
 * Explanation: Inserting 5 characters the string becomes "leetcodocteel".
 * Example 4:
 * Input: s = "g"
 * Output: 0
 * Example 5:
 * Input: s = "no"
 * Output: 1
 *
 * Approach: Use the longest common subsequence (problem 1143) to find the length of the longest palindrome in the
 * string, to do that, use given string and reversed given string to that problem 1143.
 * Then given-string-length - longest palindrome would solve it.
 *
 */
public class LC1312MinimumInsertionStepsToMakeStringPalindrome {

    public int minInsertions(String s) {
        if(s == null) return 0;

        String s1 = s;
        String s2 = new StringBuilder(s).reverse().toString();

        int maxPalindrome = longestPalindrome(s1, s2);
        //System.out.println("s1:" + s1 + " s2:" + s2 + " maxpalindrome:" + maxPalindrome);

        return s.length() - (maxPalindrome);
    }

    private int longestPalindrome(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();

        int dp[][] = new int[s1Len+1][s2Len+1];

        for(int r = 0; r < s1Len; r++) {
            for(int c = 0; c < s2Len; c++) {
                if(s1.charAt(r) == s2.charAt(c)) {
                    dp[r+1][c+1] = dp[r][c] + 1;
                } else {
                    dp[r+1][c+1] = Math.max(dp[r][c+1], dp[r+1][c]);
                }
            }
        }

        return dp[s1Len][s2Len];
    }

}
