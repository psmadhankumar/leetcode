package io.lc.prep.string.palindrome;

/**
 * The way I have done is to use the int[] array with 128
 * (to handle the both lower and upper character. And then keep adding the result count
 * as long as it is even. And when it is odd count then add them minus one.
 * And have the variable to add one last count at the end.
 *
 * However, more elegant solution is to add the answer as (count-of-characters / 2) * 2,
 * this way we can add only the even numbers for the result. Then next check if count-of-characters % 2 is 1
 * and answer % 2 == 0 then one count is not added, just add once.
 *
 *
 */
public class LC409LongestPalindrome {

    public int longestPalindrome(String s) {
        int[] chars = new int[128];

        for(char c : s.toCharArray()) { chars[c]++; }

        int result = 0;
        boolean isOddExists = false;
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] % 2 == 0) result += chars[i];
            else if(chars[i] % 2 == 1) {
                result += chars[i] - 1;
                isOddExists = true;
            }
        }

        if(isOddExists) result += 1;

        return result;
    }
}
