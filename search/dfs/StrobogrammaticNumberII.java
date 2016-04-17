package search.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Find all strobogrammatic numbers that are of length = n.

For example,
Given n = 2, return ["11","69","88","96"].

Hint:

1. Try to use recursion and notice that it should recurse with n - 2 instead of n - 1.
 */
public class StrobogrammaticNumberII {
    int[][] num = new int[][]{{1, 1}, {6, 9}, {8, 8}, {9, 6}, {0, 0}};
    int[] oneNum = new int[]{0, 1, 8};
    public List<String> findStrobogrammatic(int n) {
        List<String> rst = new ArrayList<String>();
        rst.add("");
        if (n == 0) {
            return rst;
        }
        if (n % 2 == 1) {
            dfs(rst, 1, n);
        } else {
            dfs(rst, 2, n);
        }
        return rst;
    }
    private void dfs(List<String> rst, int count, int n) {
        if (count == 1) {
            rst.remove(0);
            for (int i = 0; i < 3; i++) {
                rst.add(String.valueOf(oneNum[i]));
            }
        } else {
            int size = rst.size();
            for (int i = 0; i < size; i++) {
                String cur = rst.remove(0);
                for (int j = 0; j < (count == n ? 4 : 5); j++) {
                    rst.add(num[j][0] + cur + num[j][1]);
                }
            }
        }
        if (count == n) {
            return;
        } else {
            dfs(rst, count + 2, n);
        }
    }
}
