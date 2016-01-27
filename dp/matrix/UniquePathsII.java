package dp.matrix;
/*
 * matrix dp往往能通过优化扫描顺序减小空间的使用
 * 0. 不能排序, 求所有可能的路径总数, matrix -> dp
 * 1. f[i] -> 从起点到当前这一层每一个位置所有可能的路径总数
 * 2. 若x[i] = 0, f[i] = f[i - 1] + f[i], f[0] = 1; 若x[i] = 1, f[i] = 0; f[0] = 0 ->
 *    每一个位置等于从左边来和从上边来的可能的和, 每一层的第一个位置可能性为1; 若这个位置是obstacle, 则不管在哪路径可能性都为0
 * 3. 在第一层， 若x[i] = 0, 每一个位置f[i] = 1; 若x[i] = 1, 则以后所有f[i] = 0 ->
 *    在第一层，每个位置的可能性都只为1, 如果是obstacle则后面所有的位置都不能由起点到达
 *    并且每一层的第一个位置都为1, 如果某一层开始第一个位置是obstacle,则后面所有层的第一个位置都为0
 * 4. 返回最后一层的f[n - 1] -> 答案是最后一层的最后一个位置的值
 */

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if ((obstacleGrid == null) || (obstacleGrid.length == 0) || (obstacleGrid[0].length == 0)) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] path = new int[n];
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 0) {
            	// 第一层只要出现obstacle，那后面所有都为0
                path[i] = 1;
            } else {
                break;
            }
        }
        for (int k = 1; k < m; k++) {
        	// 这里代表每一层起始位置， 只要上一层是0，不管这层是多少都是0；上一层是1，如果这一层是obstacle，那也为0
            if (obstacleGrid[k][0] == 1) {
                path[0] = 0;
            }
            for (int i = 1; i < n; i++) {
                if (obstacleGrid[k][i] == 1) {
                    path[i] = 0;
                } else {
                    path[i] = path[i - 1] + path[i];
                }
            }
        } 
        return path[n - 1];
    }
}
