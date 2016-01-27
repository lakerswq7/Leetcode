package dp.matrix;
/*
 * matrix dp往往能通过优化扫描顺序减小空间的使用
 * 0. 不能排序, 求所有可能的路径总数, matrix -> dp
 * 1. f[i] -> 从起点到当前这一层每一个位置所有可能的路径总数
 * 2. f[i] = f[i - 1] + f[i]; f[0] = 1 -> 每一个位置等于从左边来和从上边来的可能的和; 每一层的第一个位置的可能为1
 * 3. 在第一层， 每一个位置f[i] = 1 -> 在第一层，每个位置的可能性都只为1,并且每一层的第一个位置都为1
 * 4. 返回最后一层的f[n - 1] -> 答案是最后一层的最后一个位置的值
 */

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if ((m == 0) || (n == 0)) {
            return 0;
        }
        int[] sum = new int[n];
        for (int i = 0; i < n; i++) {
            sum[i] = 1;
        }
        for (int k = 1; k < m; k++) {
            for (int i = 1; i < n; i++) {
                sum[i] = sum[i - 1] + sum[i];
            }
        }
        return sum[n - 1];
    }
}
