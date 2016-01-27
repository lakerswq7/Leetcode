package search.dfs;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> letters = new ArrayList<String>();
        if (digits == null) {
            return letters;
        }
        String[] number = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        getCombinations(letters, new StringBuilder(), digits, number, 0);
        return letters;
    }
    public void getCombinations(List<String> letters, StringBuilder comb, String digits, String[] number, int pos) {
        if (pos == digits.length()) {
            letters.add(comb.toString());
            return;
        }
        char cur = digits.charAt(pos);
        String letter = number[cur - '0'];
        for (int i = 0; i < letter.length(); i++) {
            comb.append(letter.charAt(i));
            getCombinations(letters, comb, digits, number, pos + 1);
            comb.deleteCharAt(comb.length() - 1);
        }
    }
}
