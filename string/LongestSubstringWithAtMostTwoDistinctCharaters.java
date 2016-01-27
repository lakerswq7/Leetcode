package string;

import java.util.HashMap;

public class LongestSubstringWithAtMostTwoDistinctCharaters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int start = 0;
        int max = 0;
        int end = 0;
        while (end < s.length()) {
            char cur = s.charAt(end);
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) + 1);
                end++;
            } else if (map.size() < 2){
                map.put(cur, 1);
                end++;
            } else {
                char del = s.charAt(start);
                if (map.get(del) == 1) {
                    map.remove(del);
                } else {
                    map.put(del, map.get(del) - 1);
                }
                start++;
            }
            max = Math.max(max, end - start);
        }
        return max;
    }
}
