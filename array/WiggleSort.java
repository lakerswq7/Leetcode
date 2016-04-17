package array;
/**
 * 
 * Given an unsorted array nums, reorder it in-place such
 * that nums[0] <= nums[1] >= nums[2] <= nums[3]....
 * For example, given nums = [3, 5, 2, 1, 6, 4], 
 * one possible answer is [1, 6, 2, 5, 3, 4].
 *
 */
public class WiggleSort {
    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 1) {
                if (nums[i] < nums[i - 1]) {
                    swap(nums, i, i - 1);
                }
            } else if (i != 0){
                if (nums[i] > nums[i - 1]) {
                    swap(nums, i, i - 1);
                }
            }
        }
    }
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
