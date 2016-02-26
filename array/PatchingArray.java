package array;

public class PatchingArray {
    public int minPatches(int[] nums, int n) {
        int index = 0;
        long max = 0;
        int insert = 0;
        while (max < n) {
            if (index < nums.length && nums[index] <= max + 1) {
                max += nums[index];
                index++;
            } else {
                max += max + 1;
                insert++;
            }
        }
        return insert;
    }
}
