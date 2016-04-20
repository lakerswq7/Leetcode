package search.dfs;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.

Examples:
pattern = "abab", str = "redblueredblue" should return true.
pattern = "aaaa", str = "asdasdasdasd" should return true.
pattern = "aabb", str = "xyzabcxzyabc" should return false.
Notes:
You may assume both pattern and str contains only lowercase letters.
 */
public class WordPatternII {
    public boolean wordPatternMatch(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<Character, String>();
        HashSet<String> set = new HashSet<String>();
        return match(pattern, str, map, set);
    }
    private boolean match(String pattern, String str, HashMap<Character, String> map, HashSet<String> set) {
        if (pattern.length() == 0 && str.length() == 0) {
            return true;
        }
        if (pattern.length() == 0 || str.length() == 0) {
            return false;
        }
        char p = pattern.charAt(0);
        for (int i = 0; i < str.length(); i++) {
            String cur = str.substring(0, i + 1);
            if (map.containsKey(p) && map.get(p).equals(cur)) {
                if (match(pattern.substring(1), str.substring(i + 1), map, set)) {
                    return true;
                }
            }
            if (!map.containsKey(p) && !set.contains(cur)) {
                map.put(p, cur);
                set.add(cur);
                if (match(pattern.substring(1), str.substring(i + 1), map, set)) {
                    return true;
                }
                map.remove(p);
                set.remove(cur);
            }
        }
        return false;
    }
}
