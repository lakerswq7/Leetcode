package search.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
/**
 * There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.

For example,
Given the following words in dictionary,

[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]
The correct order is: "wertf".

Note:
You may assume all letters are in lowercase.
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return any one of them is fine.
 * 
 */

/*
 * 注意这里的sort指的是words之间是排序的，
 * 而不是指一个word中各个letters是排序的
 * 实际上就是在构建output和input的时候用不同的方式
 */
public class AlienDictionary {
	public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        HashMap<Character, Integer> input = new HashMap<Character, Integer>();
        HashMap<Character, ArrayList<Character>> map = new HashMap<Character, ArrayList<Character>>();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                input.put(word.charAt(i), 0);
            }
        }
        for (int i = 1; i < words.length; i++) {
            for (int j = 0; j < Math.min(words[i].length(), words[i - 1].length()); j++) {
                char m = words[i].charAt(j);
                char n = words[i - 1].charAt(j);
                if (m != n) {
                    input.put(m, input.get(m) + 1);
                    if (!map.containsKey(n)) {
                        map.put(n, new ArrayList<Character>());
                    }
                    map.get(n).add(m);
                    break;
                }
            }
        }
        Queue<Character> queue = new LinkedList<Character>();
        StringBuilder sb = new StringBuilder();
        for (char c : input.keySet()) {
            if (input.get(c) == 0) {
                queue.offer(c);
            }
        }
        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            if (!map.containsKey(c)) {
                continue;
            }
            for (char next : map.get(c)) {
                input.put(next, input.get(next) - 1);
                if (input.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }
        if (sb.length() != input.size()) {
            return "";
        }
        return sb.toString();
    }
}
