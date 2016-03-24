package search.bucketsort;

import java.util.HashMap;

public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || t < 0 || k < 0) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int key = getKey(nums[i], t);
            if (map.containsKey(key)) {
                return true;
            }
            if (map.containsKey(key + 1) && Math.abs((long)map.get(key + 1) - nums[i]) <= t) {
                return true;
            }
            if (map.containsKey(key - 1) && Math.abs((long)map.get(key - 1) - nums[i]) <= t) {
                return true;
            }
            map.put(key, nums[i]);
            if (i >= k) {
                map.remove(getKey(nums[i - k], t));
            }
        }
        return false;
    }
    private int getKey(int num, int t) {
        if (t == 0) {
            return num;
        }
        int key = num / (t + 1);
        if (num < 0) {
            key -= 1;
        }
        return key;
    }
}
