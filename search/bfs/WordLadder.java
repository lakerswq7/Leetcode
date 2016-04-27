package search.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null) {
            return 0;
        }
        HashSet<String> dic = new HashSet<String>(wordList);
        int len = 1;
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        if (dic.contains(beginWord)) {
            dic.remove(beginWord);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            len++;
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                for (int j = 0; j < cur.length(); j++) {
                    for (char k = 'a'; k <= 'z'; k++) {
                        char[] a = cur.toCharArray();
                        a[j] = k;
                        String temp = new String(a);
                        if (temp.equals(endWord)) {
                            return len;
                        }
                        if (dic.contains(temp)) {
                            queue.offer(temp);
                            dic.remove(temp);
                        }
                    }
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
    	Set<String> dict = new HashSet<String>();
    	dict.add("ad");
    	dict.add("bs");
    	dict.add("cc");
    	WordLadder sol = new WordLadder();
    	System.out.println(sol.ladderLength("as", "ab", dict));
    }
}
