package io.lc.prep.string.anagram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
 *
 * "abc" -> "bcd" -> ... -> "xyz"
 * Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
 *
 * Example:
 *
 * Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
 * Output:
 * [
 *   ["abc","bcd","xyz"],
 *   ["az","ba"],
 *   ["acef"],
 *   ["a","z"]
 * ]
 */
public class LC249GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {

        //1. first loop through String
        //2. Build the difference, first character is zero and second character is difference to first one. When the characters became cyclic (means if 2nd char minus first is negative) then add 26 to it
        //3. Check in map if it is present, then group it

        Map<String, List<String>> map = new HashMap<>();

        for(String str : strings) {
            char[] chars = str.toCharArray();

            if(chars.length == 1) {
                map.computeIfAbsent("0", k -> new ArrayList<String>()).add(str);
                continue;
            }

            StringBuilder sb = new StringBuilder();
            sb.append("0");
            for(int i = 1; i < chars.length; i++) {
                sb.append("#");
                int difference = chars[i] - chars[i-1];
                if(difference >= 0) {sb.append(difference);}
                else{sb.append(difference + 26);}
            }

            map.computeIfAbsent(sb.toString(), k -> new ArrayList<String>()).add(str);
        }

        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String,List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }
}
