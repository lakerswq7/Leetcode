package math;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> code = new ArrayList<Integer>();
        if (n < 0) {
            return code;
        }
        code.add(0);
        for (int i = 1; i <= n; i++) {
            int k = 1 << (i - 1);
            int size = code.size();
            for (int j = size - 1; j >= 0; j--) {
                code.add(k + code.get(j));
            }
        }
        return code;
    }
}
