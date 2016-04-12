package array;

/**
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = ¡°coding¡±, word2 = ¡°practice¡±, return 3.
Given word1 = "makes", word2 = "coding", return 1.

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */
public class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int min = Integer.MAX_VALUE;
        int last1 = -1;
        int last2 = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                if (last2 != -1) {
                    min = Math.min(min, i - last2);
                }
                last1 = i;
            } else if (words[i].equals(word2)){
                if (last1 != - 1) {
                    min = Math.min(min, i - last1);
                }
                last2 = i;
            }
        }
        return min;
    }
}
