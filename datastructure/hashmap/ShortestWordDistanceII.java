package datastructure.hashmap;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters. How would you optimize it?

Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = ¡°coding¡±, word2 = ¡°practice¡±, return 3.
Given word1 = "makes", word2 = "coding", return 1.

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */
public class ShortestWordDistanceII {
	public class WordDistance {
	    HashMap<String, ArrayList<Integer>> dict;
	    public WordDistance(String[] words) {
	        dict = new HashMap<String, ArrayList<Integer>>();
	        for (int i = 0; i < words.length; i++) {
	            if (!dict.containsKey(words[i])) {
	                dict.put(words[i], new ArrayList<Integer>());
	            }
	            dict.get(words[i]).add(i);
	        }
	    }

	    public int shortest(String word1, String word2) {
	        ArrayList<Integer> list1 = dict.get(word1);
	        ArrayList<Integer> list2 = dict.get(word2);
	        int min = Integer.MAX_VALUE;
	        int i1 = 0; 
	        int i2 = 0;
	        while (i1 < list1.size() && i2 < list2.size()) {
	            min = Math.min(min, Math.abs(list1.get(i1) - list2.get(i2)));
	            if (list1.get(i1) < list2.get(i2)) {
	                i1++;
	            } else {
	                i2++;
	            }
	        }
	        return min;
	    }
	}

	// Your WordDistance object will be instantiated and called as such:
	// WordDistance wordDistance = new WordDistance(words);
	// wordDistance.shortest("word1", "word2");
	// wordDistance.shortest("anotherWord1", "anotherWord2");
}
