package datastructure.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            for (int k = 0; k <= words[i].length(); k++) {
                String str1 = words[i].substring(0, k);
                String str2 = words[i].substring(k);
                if (isPalindrome(str1)) {
                    String temp = new StringBuilder(str2).reverse().toString();
                    if (map.containsKey(temp) && map.get(temp) != i) {
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(map.get(temp));
                        list.add(i);
                        rst.add(list);
                    }
                }
                if (isPalindrome(str2)) {
                    String temp = new StringBuilder(str1).reverse().toString();
                    if (map.containsKey(temp) && map.get(temp) != i && str2.length() != 0) {
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(i);
                        list.add(map.get(temp));
                        rst.add(list);
                    }
                }
            }
        }
        return rst;
    }
    private boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
