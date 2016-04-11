package array;

import java.util.Arrays;

public class WiggleSortII {
	/*
	 * O(nlogn) 时间
	 * O(n) 空间
	 */
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int mid = (nums.length - 1) / 2;
        int end = nums.length - 1;
        int[] temp = new int[nums.length];
        for (int i = 0; i < temp.length; i++) {
            if((i & 1) == 0) {
                temp[i] = nums[mid];
                mid--;
            } else {
                temp[i] = nums[end];
                end--;
            }
        }
        for (int i = 0; i < temp.length; i++) {
            nums[i] = temp[i];
        }
    }
    
    /*
     * O(n)时间
     * O(1)空间
     * 对index进行了一个映射顺序为1,3,5,7,0,2,4,6,8
     * 数字顺序由大到小填到这些位置去
     * 这里找中位数的平均复杂度为O(n)
     */
    int n = 0;
    public void wiggleSort2(int[] nums) {
        n = nums.length;
        int median = findMedian(nums, 0, n - 1, (n + 1) / 2);
        int start = 0, mid = 0, end = n - 1;
        while (mid <= end) {
            if (nums[idx(mid)] > median) {
                swap(nums, idx(start), idx(mid));
                start++;
                mid++;
            } else if (nums[idx(mid)] < median) {
                swap(nums, idx(mid), idx(end));
                end--;
            } else {
                mid++;
            }
        }
    }
    private int idx(int i) {
        return (i * 2 + 1) % (n | 1);
    }
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    private int findMedian(int[] nums, int start, int end, int k) {
        if (start >= end) {
            return nums[end];
        }
        int pivot = partition(nums, start, end);
        int count = pivot - start + 1;
        if (count == k) {
            return nums[pivot];
        }
        return count > k ? findMedian(nums, start, pivot - 1, k) : findMedian(nums, pivot + 1, end, k - count);
    }
    private int partition(int[] nums, int start, int end) {
        int val = nums[start];
        int flag = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] <= val) {
                flag++;
                swap(nums, i, flag);
            }
        }
        swap(nums, start, flag);
        return flag;
    }
}
