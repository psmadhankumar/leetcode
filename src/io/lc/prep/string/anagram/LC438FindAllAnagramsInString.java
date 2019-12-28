package io.lc.prep.string.anagram;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * The order of output does not matter.
 * Example 1:
 * Input:
 * s: "cbaebabacd" p: "abc"
 * Output:
 * [0, 6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 * Input:
 * s: "abab" p: "ab"
 * Output:
 * [0, 1, 2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 * TIPS:
 * 1. if S length less than p length, then nothing to do
 * 2. Build the P array
 * 3. build the S Array for the length of P
 * 4. compare the first until p length
 * 5. do the sliding window to compare the result of characters
 * 6. Simple compare operation for int array
 */
public class LC438FindAllAnagramsInString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        int pLen = p.length();
        int sLen = s.length();

        //1. if S length less than p length, then nothing to do
        if(sLen < pLen) return result;

        //2. Build the P array
        int[] pChars = new int[26];
        for(char x : p.toCharArray()) {
            pChars[x - 'a']++;
        }

        //3. build the S Array for the length of P
        char[] sArray = s.toCharArray();
        int[] sChars = new int[26];
        for(int i = 0; i < pLen; i++) {
            sChars[sArray[i] - 'a']++;
        }

        //4. compare the first until p length
        if(isSame(sChars, pChars)) result.add(0);

        //5. do the sliding window to compare the result of characters
        for(int i = pLen; i < sLen; i++) {
            char previous = sArray[i - pLen];
            char current = sArray[i];

            sChars[previous - 'a']--;
            sChars[current - 'a']++;

            if(isSame(sChars, pChars)) result.add(i-pLen+1);
        }

        return result;
    }

    //6. Simple compare operation for int array
    private boolean isSame(int[] s, int[] p) {
        for(int i = 0; i < s.length; i++) {
            if(s[i] != p[i]) return false;
        }

        return true;
    }

}
