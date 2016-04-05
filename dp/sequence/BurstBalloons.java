package dp.sequence;

public class BurstBalloons {
	/*
	 * 这里的思路是枚举最后一个扎破的气球，利用左右两边算出的结果
	 * 三层循环，先是循环范围，在循环启示位置，再循环最后一次扎破位置
	 * 注意这里d[r][l]代表r到l之间捅破的最大值，但不包括边界
	 */
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length + 2;
        int[] balloons = new int[n];
        for (int i = 0; i < nums.length; i++) {
            balloons[i + 1] = nums[i];
        }
        balloons[0] = balloons[n - 1] = 1;
        int[][] dp = new int[n][n];
        for (int k = 2; k <= n; k++) {
            for (int i = 0; i <= n - k; i++) {
                for (int j = i + 1; j < i + k - 1; j++) {
                    dp[i][i + k - 1] = Math.max(dp[i][i + k - 1], balloons[j] * balloons[i] * balloons[i + k - 1] + dp[i][j] + dp[j][i + k - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
