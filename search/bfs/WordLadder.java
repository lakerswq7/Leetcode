package search.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	public int ladderLength(String start, String end, Set<String> dict) {
        if ((start == null) || (end == null) || (dict == null)) {
            return 0;
        }
        HashSet<String> dictionary = new HashSet<String>(dict);
        int len = 1;
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        if (dictionary.contains(start)) {
            dictionary.remove(start);
        }
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            len++;
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                for (int j = 0; j < cur.length(); j++) {
                    for (char k = 'a'; k <= 'z'; k++) {
                        String temp = cur.substring(0, j) + k + cur.substring(j + 1, cur.length());
                        if (temp.equals(end)) {
                            return len;
                        }
                        if (dictionary.contains(temp)){
                            queue.offer(temp);
                            dictionary.remove(temp);
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
