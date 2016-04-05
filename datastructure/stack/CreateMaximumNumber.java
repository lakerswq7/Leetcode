package datastructure.stack;

public class CreateMaximumNumber {
/*
 * ��Ϊ����
 * ö�� i ���� 0 ~ k, ��ʾ�ڵ�һ��������ȡ����
 * 1. ȡ����������������
 * 2. ������������ϲ����ҵ������Ǹ�
 */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int[] rst = new int[k];
        for (int i = 0; i <= k; i++) {
            if (i > m || k - i > n) {
                continue;
            }
            int[] array1 = getK(nums1, i);
            int[] array2 = getK(nums2, k - i);
            int[] candidate = merge(array1, array2);
            if (isGreater(candidate, 0, rst, 0)) {
                rst = candidate;
            }
        }
        return rst;
    }
    /*
     * ����������ϲ�
     */
    private int[] merge(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length + nums2.length];
        int i1 = 0, i2 = 0, i = 0;
        while (i1 < nums1.length || i2 < nums2.length) {
            if (isGreater(nums1, i1, nums2, i2)) {
                ans[i++] = nums1[i1++];
            } else {
                ans[i++] = nums2[i2++];
            }
        }
        return ans;
    }
    /*
     * �ж���������Ĵ�С
     */
    private boolean isGreater(int[] nums1, int start1, int[] nums2, int start2) {
        while(start1 < nums1.length && start2 < nums2.length) {
            if (nums1[start1] > nums2[start2]) {
                return true;
            } else if (nums1[start1] < nums2[start2]) {
                return false;
            }
            start1++;
            start2++;
        }
        return start1 != nums1.length;
    }
    /*
     * ��һ��������ȡ������K����
     */
    private int[] getK(int[] nums, int k) {
        int[] ans = new int[k];
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            while (pos != 0 && pos - 1 + nums.length - i >= k && ans[pos - 1] < nums[i]) {
                pos--;
            }
            if (pos < k) {
                ans[pos++] = nums[i];
            }
        }
        return ans;
    }
}
