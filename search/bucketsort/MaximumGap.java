package search.bucketsort;

import java.util.Arrays;
/*
 * 这题可用radix sort 进行sort
 * 或者直接用bucket sort, 时间复杂度更低
 */
/*
 * bucket sort,
 * 思想是:
 * A. 把数字投放到各个桶中
 * B. 保证max gap不会出现在同一个桶里，这样只要算桶间的最大最小值差就可得到
 * 当均匀分布的时候，max gap最小。所以map gap一定大于等于ceiling((Max - Min) / (N - 1))，
 * 所以令桶大小len = ((Max - Min) / (N - 1)) + 1, 这样同一个桶里的最大可能差值就是len - 1，
 * 这样可以保证最大差值出现在桶间。
 * 这里在满足基本要求的同时要让桶尽量大，这样可以减少复杂度。
 * 这样桶的个数为 ((Max - Min) / len) + 1
 * 把每个数投到的序列为(num[i] - Min) / len的桶中，维护每个桶的最大值最小值
 * 最后计算每个有数的桶的最小值和前一个有数的桶的最大值的差即可，同时要计算第一个桶的最大最小值差，防止只有一个桶的情况。
 * 
 */
public class MaximumGap {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int e : nums) {
            max = Math.max(max, e);
            min = Math.min(min, e);
        }
        int len = (max - min) / (nums.length - 1) + 1;
        int n = (max - min) / len + 1;
        int[] bucketMax = new int[n];
        int[] bucketMin = new int[n];
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        for (int e : nums) {
            int index = (e - min) / len;
            bucketMax[index] = Math.max(bucketMax[index], e);
            bucketMin[index] = Math.min(bucketMin[index], e);
        }
        //防止只有一个桶的情况
        int maxGap = bucketMax[0] - bucketMin[0];
        int pre = bucketMax[0];
        //不是每个桶都有数，要找到有效的桶
        for (int i = 1; i < n; i++) {
            if (bucketMin[i] != Integer.MAX_VALUE) {
                maxGap = Math.max(maxGap, bucketMin[i] - pre);
                pre = bucketMax[i];
            }
        }
        return maxGap;
    }
/*
 * radix sort, 这里radix选取的是10
 */
//    public int maximumGap(int[] nums) {
//        if (nums == null || nums.length < 2) {
//            return 0;
//        }
//        int[] temp = new int[nums.length];
//        int exp = 1;
//        for (int k = 0; k < 10; k++) {
//            int[] count = new int[10];
//            for (int i = 0; i < nums.length; i++) {
//                count[(nums[i] / exp) % 10]++;
//            }
//            for (int i = 1; i < 10; i++) {
//                count[i] += count[i - 1];
//            }
//            for (int i = nums.length - 1; i >= 0; i--) {
//                temp[--count[(nums[i] / exp) % 10]] = nums[i];
//            }
//            for (int i = 0; i < nums.length; i++) {
//                nums[i] = temp[i];
//            }
//            exp *= 10;
//        }
//        int max = 0;
//        for (int i = 1; i < nums.length; i++) {
//            max = Math.max(max, nums[i] - nums[i - 1]);
//        }
//        return max;
//    }
}
