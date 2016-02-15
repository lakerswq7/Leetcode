package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
// 所谓的窗口法，sliding window的思路
public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> rst = new ArrayList<Integer>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return rst;
        }
        int m = words.length;
        int n = words[0].length();
        HashMap<String, Integer> map = getMap(words);
        for (int i = 0; i < n; i++) {
            int start = i;
            int end = i;
            HashMap<String, Integer> dic = new HashMap<String, Integer>(map);
            while (end + n <= s.length() && start + n * m <= s.length()) {
                String temp = s.substring(end, end + n);
                if (dic.containsKey(temp)) {
                    if (dic.get(temp) == 1) {
                        dic.remove(temp);
                    } else {
                        dic.put(temp, dic.get(temp) - 1);
                    }
                    end += n;
                } else {
                    if (start < end) {
                        String first = s.substring(start, start + n);
                        if (dic.containsKey(first)) {
                            dic.put(first, dic.get(first) + 1);
                        } else {
                            dic.put(first, 1);
                        }
                        start += n;
                    } else {
                        end += n;
                        start += n;
                    }
                }
                if (dic.size() == 0) {
                    rst.add(start);
                }
            }
        }
        return rst;
    }
    private HashMap<String, Integer> getMap(String[] words) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String w : words) {
            if (map.containsKey(w)) {
                map.put(w, map.get(w) + 1);
            } else {
                map.put(w, 1);
            }
        }
        return map;
    }
}
