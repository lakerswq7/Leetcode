package array;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        k = k % nums.length;
        rotateHelper(nums, 0, nums.length - k - 1);
        rotateHelper(nums, nums.length - k, nums.length - 1);
        rotateHelper(nums, 0, nums.length - 1);
    }
    public void rotateHelper(int[] nums, int start, int end) {
        int temp;
        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
