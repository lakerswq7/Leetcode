package datastructure.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> rst = new ArrayList<List<String>>();
        if (strs == null || strs.length == 0) {
            return rst;
        }
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        int[] count = new int[26];
        for (String s : strs) {
            String feature = process(s, count);
            if (!map.containsKey(feature)) {
                map.put(feature, new ArrayList<String>());
            }
            map.get(feature).add(s);
        }
        for (ArrayList<String> list : map.values()) {
            Collections.sort(list);
            rst.add(list);
        }
        return rst;
    }
    private String process(String s, int[] count) {
        Arrays.fill(count, 0);
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i : count) {
            sb.append("&");
            sb.append(i);
        }
        return sb.toString();
    }
}
