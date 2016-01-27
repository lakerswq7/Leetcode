package string;

import java.util.HashMap;

public class MinimumWindowSubstring {
	public String minWindow(String S, String T) {
        if (S == null || T == null) {
            return null;
        }
        int len = T.length();
        HashMap<Character, Integer> dic = new HashMap<Character, Integer>();
        HashMap<Character, Integer> window = new HashMap<Character, Integer>();
        for (int i = 0; i < len; i++) {
            if(dic.containsKey(T.charAt(i))) {
                dic.put(T.charAt(i), dic.get(T.charAt(i)) + 1);
            } else {
                dic.put(T.charAt(i), 1);
            }
        }
        int count = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        String minWindow = "";
        for (int i = 0; i < S.length(); i++) {
            char cur = S.charAt(i);
            if (!dic.containsKey(cur)) {
                continue;
            }
            if (window.containsKey(cur)) {
                window.put(cur, window.get(cur) + 1);
            } else {
                window.put(cur, 1);
            }
            if (window.get(cur) <= dic.get(cur)) {
                count++;
            }
            if (count == len) {
                while (!window.containsKey(S.charAt(start)) || window.get(S.charAt(start)) > dic.get(S.charAt(start))) {
                    if (window.containsKey(S.charAt(start))) {
                        window.put(S.charAt(start), window.get(S.charAt(start)) - 1);
                    }
                    start++;
                }
                int l = i - start + 1;
                if (l < minLen) {
                    minLen = l;
                    minWindow = S.substring(start, i + 1);
                }
            }
        }
        return minWindow;
    }
}
