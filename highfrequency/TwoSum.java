package highfrequency;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] rst = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                rst[0] = map.get(nums[i]);
                rst[1] = i;
                return rst;
            } else {
                map.put(target - nums[i], i);
            }
        }
        return rst;
    }
}
