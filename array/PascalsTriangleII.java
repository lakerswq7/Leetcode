package array;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        if (rowIndex < 0) {
            return result;
        }
        List<Integer> last = new ArrayList<Integer>();
        List<Integer> tmp;
        for (int i = 0; i <= rowIndex; i++) {
            result.add(1);
            last.add(1);
        }
        for (int i = 2; i <= rowIndex; i++) {
            tmp = last;
            last = result;
            result = tmp;
            for (int j = 1; j < i; j++) {
                result.set(j, last.get(j - 1) + last.get(j));
            }
        }
        return result;
    }
}
