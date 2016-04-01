package search.dfs;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> rst = new ArrayList<String>();
        if (num == null || num.length() == 0) {
            return rst;
        }
        dfs(rst, "", num, 0, 0, 0, target);
        return rst;
    }
    private void dfs(List<String> rst, String path, String num, int pos, long result, long temp, int target) {
        if (outOfRange(temp) || outOfRange(result)) {
            return;
        }
        if (pos == num.length()) {
            result += temp;
            if (result == target) {
                rst.add(path);
            }
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if (outOfRange(cur)) {
                return;
            }
            if (pos == 0) {
                dfs(rst, path + cur, num, i + 1, 0, cur, target);
            } else {
                dfs(rst, path + "+" + cur, num, i + 1, result + temp, cur, target);
                dfs(rst, path + "-" + cur, num, i + 1, result + temp, -cur, target);
                dfs(rst, path + "*" + cur, num, i + 1, result, temp * cur, target);
            }
            if (num.charAt(pos) == '0') {
                break;
            }
        }
    }
    private boolean outOfRange(long num) {
        return num > Integer.MAX_VALUE || num < Integer.MIN_VALUE;
    }
}
