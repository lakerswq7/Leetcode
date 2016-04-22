package search.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no palindromic permutation could be form.

For example:

Given s = "aabb", return ["abba", "baab"].

Given s = "abc", return [].

Hint:

If a palindromic permutation exists, we just need to generate the first half of the string.
To generate all distinct permutations of a (half of) string, use a similar approach from: Permutations II or Next Permutation.
 */
public class PalindromePermutaionII {
    String single = "";
    public List<String> generatePalindromes(String s) {
        List<String> rst = new ArrayList<String>();
        HashMap<Character, Integer> letters = new HashMap<Character, Integer>();
        if (s == null || !canPermPalin(s, letters)) {
            return rst;
        }
        StringBuilder sb = new StringBuilder();
        int count = s.length() / 2;
        dfs(sb, rst, count, letters);
        return rst;
    }
    private void dfs(StringBuilder sb, List<String> rst, int count, HashMap<Character, Integer> letters) {
        if (count == 0) {
            rst.add(sb.toString() + single + new StringBuilder(sb).reverse().toString());
            return;
        }
        for (char c : letters.keySet()) {
            if (letters.get(c) != 0) {
                count--;
                letters.put(c, letters.get(c) - 1);
                sb.append(c);
                dfs(sb, rst, count, letters);
                sb.deleteCharAt(sb.length() - 1);
                letters.put(c, letters.get(c) + 1);
                count++;
            }
        }
    }
    private boolean canPermPalin(String s, HashMap<Character, Integer> letters) {
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (!letters.containsKey(cur)) {
                letters.put(cur, 1);
            } else {
                letters.put(cur, letters.get(cur) + 1);
            }
        }
        int count = 0;
        for (char c : letters.keySet()) {
            if (letters.get(c) % 2 == 1) {
                single = String.valueOf(c);
                count++;
            }
            letters.put(c, letters.get(c) / 2);
        }
        count -= s.length() % 2;
        return count == 0;
    }
}
