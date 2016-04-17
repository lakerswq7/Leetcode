package search.bfs;

import java.util.HashMap;
import java.util.HashSet;
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
        HashMap<Character, HashSet<Character>> output = new HashMap<Character, HashSet<Character>>();
        HashMap<Character, Integer> input = new HashMap<Character, Integer>();
        StringBuilder order = new StringBuilder();
        Queue<Character> queue = new LinkedList<Character>();
        int count = 0;
        for (int k = 0; k < words.length; k++) {
            for (int i = 0; i < words[k].length(); i++) {
                char c = words[k].charAt(i);
                if (!output.containsKey(c)) {
                    output.put(c, new HashSet<Character>());
                }
                if (!input.containsKey(c)) {
                    count++;
                    input.put(c, 0);
                }
            }
        }
        for (int k = 0; k < words.length; k++) {
            for (int i = 0; i < words[k].length(); i++) {
                char c = words[k].charAt(i);
                if (k != 0 && i < words[k - 1].length() && words[k - 1].charAt(i) != c) {
                    if (!output.get(words[k - 1].charAt(i)).contains(c)) {
                        output.get(words[k - 1].charAt(i)).add(c);
                        input.put(c, input.get(c) + 1);
                    }
                    break;
                }
            }
        }
        for (char c : input.keySet()) {
            if (input.get(c) == 0) {
                queue.offer(c);
            }
        }
        while (!queue.isEmpty()) {
            char cur = queue.poll();
            order.append(cur);
            count--;
            for (char n : output.get(cur)) {
                input.put(n, input.get(n) - 1);
                if (input.get(n) == 0) {
                    queue.offer(n);
                }
            }
        }
        if (count != 0) {
            return "";
        }
        return order.toString();
    }
}
