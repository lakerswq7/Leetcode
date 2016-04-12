package array;
/**
 * This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.

Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

word1 and word2 may be the same and they represent two individual words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = ¡°makes¡±, word2 = ¡°coding¡±, return 1.
Given word1 = "makes", word2 = "makes", return 3.

Note:
You may assume word1 and word2 are both in the list.
 */
public class ShortestWordDistanceIII {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int min = Integer.MAX_VALUE;
        int last1 = -1;
        int last2 = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                if (last2 != -1) {
                    min = Math.min(min, i - last2);
                }
                if (word1.equals(word2)) {
                    last2 = i;
                } else {
                    last1 = i;
                }
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
