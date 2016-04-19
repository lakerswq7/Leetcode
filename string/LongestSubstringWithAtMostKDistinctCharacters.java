package string;

import java.util.HashMap;

public class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
            while (map.size() > k) {
                if (map.get(s.charAt(start)) == 1) {
                    map.remove(s.charAt(start));
                } else {
                    map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                }
                start++;
            }
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}
