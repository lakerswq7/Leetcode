package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
// 所谓的窗口法，sliding window的思路
public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> rst = new ArrayList<Integer>();
        if (S == null || L == null || S.length() == 0 || L.length == 0) {
            return rst;
        }
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int m = L.length;
        int n = L[0].length();
        for (String l : L) {
            if (map.containsKey(l)) {
                map.put(l, map.get(l) + 1);
            } else {
                map.put(l, 1);
            }
        }
        for (int i = 0; i < n; i++) {
            int start = i;
            int end = i;
            HashMap<String, Integer> dic = new HashMap<String, Integer>(map);
            while (end + n <= S.length()) {
                String temp = S.substring(end, end + n);
                if (dic.containsKey(temp)) {
                    if (dic.get(temp) == 1) {
                        dic.remove(temp);
                    } else {
                        dic.put(temp, dic.get(temp) - 1);
                    }
                    end += n;
                } else {
                    if (start < end) {
                        String first = S.substring(start, start + n);
                        if (dic.containsKey(first)) {
                            dic.put(first, dic.get(first) + 1);
                        } else {
                            dic.put(first, 1);
                        }
                    } else {
                        end += n;
                    }
                    start += n;
                }
                if (start + n * m > S.length()) {
                	break;
                }
                if (dic.size() == 0) {
                    rst.add(start);
                }
            }
        }
        return rst;
    }
    public static void main(String[] args) {
    	SubstringWithConcatenationOfAllWords sol = new SubstringWithConcatenationOfAllWords();
    	String a = "abaababbaba";
    	String[] b = new String[]{"ab","ba","ab","ba"};
    	System.out.println(sol.findSubstring(a, b));
    }
}
