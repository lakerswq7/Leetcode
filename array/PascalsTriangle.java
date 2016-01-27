package array;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows <= 0) {
            return result;
        }
        ArrayList<Integer> last = new ArrayList<Integer>();
        last.add(1);
        result.add(last);
        for (int i = 2; i <= numRows; i++) {
            ArrayList<Integer> cur = new ArrayList<Integer>();
            cur.add(1);
            for (int j = 0; j < last.size() - 1; j++) {
                cur.add(last.get(j) + last.get(j + 1));
            }
            cur.add(1);
            result.add(cur);
            last = cur;
        }
        return result;
    }
}
