package datastructure.hashmap;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if ((s == null) || (s.length() == 0)) {
            return 0;
        }
        HashMap<Character, Integer> letter = new HashMap<Character, Integer>();
        int max = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (letter.containsKey(cur) && (letter.get(cur) >= start)) {
                max = Math.max(max, i - start);
                start = letter.get(cur) + 1;
            }
            letter.put(cur, i);
        }
        max = Math.max(max, s.length() - start);
        return max;
    }
}
