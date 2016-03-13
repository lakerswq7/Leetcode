package dp.sequence;

public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int max;
        int rob = 0;
        int noRob = nums[0];
        for (int i = 2; i < nums.length; i++) {
            int temp = rob;
            rob = noRob + nums[i];
            noRob = Math.max(temp, noRob);
        }
        max = noRob;
        rob = nums[1];
        noRob = 0;
        for (int i = 2; i < nums.length; i++) {
            int temp = rob;
            rob = noRob + nums[i];
            noRob = Math.max(temp, noRob);
        }
        max = Math.max(max, Math.max(rob, noRob));
        return max;
    }
}
