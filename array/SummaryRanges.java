package array;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> rst = new ArrayList<String>();
        if (nums.length == 0) {
            return rst;
        }
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] != nums[i - 1] + 1) {
                rst.add(buildRange(nums, start, i - 1));
                start = i;
            }
            if (i == nums.length - 1) {
                rst.add(buildRange(nums, start, i));
            }
        }
        return rst;
    }
    private String buildRange(int[] nums, int start, int end) {
        if (start == end) {
            return String.valueOf(nums[start]);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(nums[start]);
        sb.append("->");
        sb.append(nums[end]);
        return sb.toString();
    }
}
