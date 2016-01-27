package dp.matrix;
/*
 * matrix dp������ͨ���Ż�ɨ��˳���С�ռ��ʹ��
 * 0. ��������, ��·���͵���Сֵ, matrix -> dp
 * 1. f[i] -> ����㵽��ǰ��һ��ÿһ��λ��·���͵���Сֵ
 * 2. f[i] = min(f[i - 1] + f[i]) + x[i]; f[0] = f[0] + x[0] ->
 * 	  ÿһ��λ�õ�����ߵ���ϱߵ���С���Ǹ������������ֵ; ÿһ��ĵ�һ��λ��Ϊ��һ��ĵ�һ��λ�õ�ֵ����������
 * 3. �ڵ�һ�㣬 ÿһ��λ��f[i] = f[i - 1] + x[i] -> �ڵ�һ�㣬ÿ��λ��Ϊ����ߵ�ֵ����������
 * 4. �������һ���f[n - 1] -> �������һ������һ��λ�õ�ֵ
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
