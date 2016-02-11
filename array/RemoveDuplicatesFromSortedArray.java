package array;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1 || nums[i] != nums[i + 1]) {
                nums[len] = nums[i];
                len++;
            }
        }
        return len;
    }
}
