package search.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.

For example,
Given low = "50", high = "100", return 3. Because 69, 88, and 96 are three strobogrammatic numbers.

Note:
Because the range might be a large number, the low and high numbers are represented as string.
 *
 */
public class StrobogrammaticNumberIII {
	public int strobogrammaticInRange(String low, String high) {
        if (low.length() > high.length()) {
            return 0;
        }
        int count = getCount(low.length() + 1, high.length() - 1);
        List<String> list = new ArrayList<String>();
        list.addAll(dfs(low.length(), low.length()));
        if (low.length() != high.length()) {
            list.addAll(dfs(high.length(), high.length()));
        }
        for (String s : list) {
            if ((s.length() == low.length() && s.compareTo(low) < 0) || (s.length() == high.length() && s.compareTo(high) > 0)) {
                continue;
            }
            count++;
        }
        return count;
    }
    private List<String> dfs(int n, int max) {
        if (n == 0) {
            return Arrays.asList("");
        }
        if (n == 1) {
            return Arrays.asList("0", "8", "1");
        }
        List<String> rst = new ArrayList<String>();
        List<String> last = dfs(n - 2, max);
        for (String s : last) {
            if (n != max) {
                rst.add("0" + s + "0");
            }
            rst.add("1" + s + "1");
            rst.add("6" + s + "9");
            rst.add("8" + s + "8");
            rst.add("9" + s + "6");
        }
        return rst;
    }
    private int getCount(int low, int high) {
        int odd = 3, even = 4, count = 0;
        for (int i = 1; i <= high; i++) {
            if (i != 1 && i != 2) {
                if ((i & 1) == 1) {
                    odd = even * 3;
                } else {
                    even = even * 5;
                }
            }
            if (i >= low) {
                count += (i & 1) == 1 ? odd : even;
            }
        }
        return count;
    }
}