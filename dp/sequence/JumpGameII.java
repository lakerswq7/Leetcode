package dp.sequence;

/*
 * 0. 不能排序，求最小跳数， sequence -> dp
 * 1. f[i] -> 当跳i步的时候，最远能跳到哪里
 * 2. f[i] = max(j + A[j]), f[i - 2] < j <= f[i - 1], 且如果f[i] <= f[i - 1] 则返回-1
 * 3. f[0] = 0, f[1] = A[0]
 * 4. 当任意f[i] >= n - 1，返回i
 * 
 * 优化，因为只跟前面两个值有关，所以可以只用两个数代替
 */
public class JumpGameII {
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int step = 0;
        int max = 0;
        int lastMax = 0;
        for (int i = 0; i <= max; i++) {
            max = Math.max(max, nums[i] + i);
            if (max >= nums.length - 1) {
                return step + 1;
            }
            if (i == lastMax) {
                lastMax = max;
                step++;
            }
        }
        return -1;
    }
}
