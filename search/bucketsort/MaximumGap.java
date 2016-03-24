package search.bucketsort;

import java.util.Arrays;
/*
 * �������radix sort ����sort
 * ����ֱ����bucket sort, ʱ�临�Ӷȸ���
 */
/*
 * bucket sort,
 * ˼����:
 * A. ������Ͷ�ŵ�����Ͱ��
 * B. ��֤max gap���������ͬһ��Ͱ�����ֻҪ��Ͱ��������Сֵ��Ϳɵõ�
 * �����ȷֲ���ʱ��max gap��С������map gapһ�����ڵ���ceiling((Max - Min) / (N - 1))��
 * ������Ͱ��Сlen = ((Max - Min) / (N - 1)) + 1, ����ͬһ��Ͱ��������ܲ�ֵ����len - 1��
 * �������Ա�֤����ֵ������Ͱ�䡣
 * �������������Ҫ���ͬʱҪ��Ͱ�������������Լ��ٸ��Ӷȡ�
 * ����Ͱ�ĸ���Ϊ ((Max - Min) / len) + 1
 * ��ÿ����Ͷ��������Ϊ(num[i] - Min) / len��Ͱ�У�ά��ÿ��Ͱ�����ֵ��Сֵ
 * ������ÿ��������Ͱ����Сֵ��ǰһ��������Ͱ�����ֵ�Ĳ�ɣ�ͬʱҪ�����һ��Ͱ�������Сֵ���ֹֻ��һ��Ͱ�������
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
        //��ֹֻ��һ��Ͱ�����
        int maxGap = bucketMax[0] - bucketMin[0];
        int pre = bucketMax[0];
        //����ÿ��Ͱ��������Ҫ�ҵ���Ч��Ͱ
        for (int i = 1; i < n; i++) {
            if (bucketMin[i] != Integer.MAX_VALUE) {
                maxGap = Math.max(maxGap, bucketMin[i] - pre);
                pre = bucketMax[i];
            }
        }
        return maxGap;
    }
/*
 * radix sort, ����radixѡȡ����10
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
