package dp.sequence;

import java.util.Arrays;

public class LongestIncreaseSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] LIS = new int[nums.length];
        Arrays.fill(LIS, Integer.MAX_VALUE);
        int len = 0;
        for (int n : nums) {
            int pos = findPos(LIS, n, 0, len);
            if (pos == len) {
                len++;
            }
            LIS[pos] = n;
        }
        return len;
    }
    private int findPos(int[] LIS, int n, int low, int high) {
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (LIS[mid] < n) {
                low = mid;
            } else {
                high = mid;
            }
        }
        if (LIS[low] >= n) {
            return low;
        } else {
            return high;
        }
    }
}
