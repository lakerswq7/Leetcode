package search.dfs;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> paren = new ArrayList<String>();
        helper(paren, new StringBuilder(), n, n);
        return paren;
    }
    public void helper(List<String> paren, StringBuilder s, int left, int right) {
        if ((left == 0) && (right == 0)) {
            paren.add(s.toString());
        }
        if (left > 0) {
            s.append('(');
            helper(paren, s, left - 1, right);
            s.deleteCharAt(s.length() - 1);
        }
        if (right > left) {
            s.append(')');
            helper(paren, s, left, right - 1);
            s.deleteCharAt(s.length() - 1);
        }
    }
}
