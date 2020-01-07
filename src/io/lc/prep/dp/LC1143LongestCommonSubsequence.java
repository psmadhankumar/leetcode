package io.lc.prep.dp;

/**
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.
 *  
 * If there is no common subsequence, return 0.
 *  
 * Example 1:
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * Example 2:
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * Example 3:
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 *  
 * Constraints:
 * 	• 1 <= text1.length <= 1000
 * 	• 1 <= text2.length <= 1000
 * 	• The input strings consist of lowercase English characters only.
 *
 *
 * 	Approach: DP problem, to solve it. Such that, with two dimensional array of length + 1, then
 * 	if s1charAt(r) == s2chatAt(c)  then add from top-row & diagonal-top-column + 1. or, use maximum
 * 	b/w top-row & same column or same-row & one-column left.
 *
 *
 */
public class LC1143LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {

        int text1Len = text1.length();
        int text2Len = text2.length();

        int dp[][] = new int[text1Len+1][text2Len+1];

        for(int r = 0; r < text1Len; r++) {
            for(int c = 0; c < text2Len; c++) {

                if(text1.charAt(r) == text2.charAt(c)) {
                    dp[r+1][c+1] = dp[r][c] + 1;
                } else {
                    dp[r+1][c+1] = Math.max(dp[r][c+1], dp[r+1][c]);
                }
            }
        }

        return dp[text1Len][text2Len];
    }
}
