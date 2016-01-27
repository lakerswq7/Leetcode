package dp.matrix;
/*
 * matrix dp往往能通过优化扫描顺序减小空间的使用
 * 0. 不能排序, 求路径和的最小值, matrix -> dp
 * 1. f[i] -> 从起点到当前这一层每一个位置路径和的最小值
 * 2. f[i] = min(f[i - 1] + f[i]) + x[i]; f[0] = f[0] + x[0] ->
 * 	  每一个位置等于左边点和上边点中小的那个加上它本身的值; 每一层的第一个位置为上一层的第一个位置的值加上它本身
 * 3. 在第一层， 每一个位置f[i] = f[i - 1] + x[i] -> 在第一层，每个位置为它左边的值加上它本身
 * 4. 返回最后一层的f[n - 1] -> 答案是最后一层的最后一个位置的值
 */

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if ((grid == null) || (grid.length == 0) || (grid[0].length == 0)) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[] sum = new int[n];
        sum[0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + grid[0][i];
        }
        
        for (int k = 1; k < m; k++) {
            sum[0] = sum[0] + grid[k][0];
            for (int i = 1; i < n; i++) {
                sum[i] = Math.min(sum[i - 1], sum[i]) + grid[k][i];
            }
        }
        return sum[n - 1];
    }
}
