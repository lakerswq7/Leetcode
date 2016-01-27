package datastructure.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagrams {
    public List<String> anagrams(String[] strs) {
        List<String> anags = new ArrayList<String>();
        if ((strs == null) || (strs.length == 0)) {
            return anags;
        }
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        int[] count = new int[26];
        for (String str : strs) {
            Arrays.fill(count, 0);
            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i) - 'a']++;
            }
            String key = countToString(count);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(str);
        }
        for (ArrayList<String> list : map.values()) {
            if (list.size() > 1) {
                anags.addAll(list);
            }
        }
        return anags;
    }
    public String countToString(int[] count) {
        StringBuilder key = new StringBuilder();
        for (int i : count) {
            key.append('&');
            key.append(i);
        }
        return key.toString();
    }
}
