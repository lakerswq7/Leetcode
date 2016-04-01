package datastructure.hashmap;

import java.util.HashMap;
import java.util.HashSet;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if (strs.length != pattern.length()) {
            return false;
        }
        HashMap<Character, String> map = new HashMap<Character, String>();
        HashSet<String> set = new HashSet<String>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (!strs[i].equals(map.get(c))) {
                    return false;
                }
            } else {
                if (set.contains(strs[i])) {
                    return false;
                }
                map.put(c, strs[i]);
                set.add(strs[i]);
            }
        }
        return true;
    }
}
