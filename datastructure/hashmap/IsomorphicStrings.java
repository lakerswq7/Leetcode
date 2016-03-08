package datastructure.hashmap;

import java.util.HashMap;
import java.util.HashSet;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        HashSet<Character> set = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (map.containsKey(sc)) {
                if (tc != map.get(sc)) {
                    return false;
                }
            } else {
                if (set.contains(tc)) {
                    return false;
                }
                set.add(tc);
                map.put(sc, tc);
            }
        }
        return true;
    }
}
