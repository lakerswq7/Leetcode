package search.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a function to generate the generalized abbreviations of a word.

Example:
Given word = "word", return the following list (order does not matter):
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 *
 */
public class GeneralizedAbbreviation {
    public List<String> generateAbbreviations(String word) {
        List<String> rst = new ArrayList<String>();
        getAbbr(rst, "", word, 0, false);
        return rst;
    }
    private void getAbbr(List<String> rst, String cur, String word, int pos, boolean preNum) {
        if (pos == word.length()) {
            rst.add(cur);
            return;
        }
        for (int i = pos; i < word.length(); i++) {
            if (!preNum) {
                getAbbr(rst, cur + (i - pos + 1), word, i + 1, true);
            }
        }
        getAbbr(rst, cur + word.substring(pos, pos + 1), word, pos + 1, false);
    }
}
