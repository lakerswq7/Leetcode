package dp.sequence;

public class BurstBalloons {
	/*
	 * �����˼·��ö�����һ�����Ƶ���������������������Ľ��
	 * ����ѭ��������ѭ����Χ����ѭ����ʾλ�ã���ѭ�����һ������λ��
	 * ע������d[r][l]����r��l֮��ͱ�Ƶ����ֵ�����������߽�
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
