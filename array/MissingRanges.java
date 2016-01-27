package array;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
    public List<String> findMissingRanges(int[] A, int lower, int upper) {
        List<String> result = new ArrayList<String>();
        for (int a : A) {
            if (lower > upper) {
                break;
            }
            if (a < lower) {
                continue;
            } else if (a == lower) {
                lower += 1;
            } else {
                int end = Math.min(upper + 1, a);
                result.add(getRange(lower, end));
                lower = end + 1;
            }
        }
        if (lower <= upper) {
            result.add(getRange(lower, upper + 1));
        }
        return result;
    }
    public String getRange(int lower, int end) {
        StringBuilder sb = new StringBuilder();
        sb.append(lower);
        if (end > lower + 1) {
            sb.append("->");
            sb.append(end - 1);
        }
        return sb.toString();
    }
}
