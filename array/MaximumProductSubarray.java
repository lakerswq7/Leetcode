package array;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int pos = 0, neg = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                pos = Math.max(pos * nums[i], nums[i]);
                neg = neg * nums[i];
            } else {
                int temp = pos;
                pos = neg * nums[i];
                neg = Math.min(temp * nums[i], nums[i]);
            }
            max = Math.max(max, pos);
        }
        return max;
    }
}
