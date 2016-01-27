package dp.matrix;
/*
 * matrix dp������ͨ���Ż�ɨ��˳���С�ռ��ʹ��
 * 0. ��������, �����п��ܵ�·������, matrix -> dp
 * 1. f[i] -> ����㵽��ǰ��һ��ÿһ��λ�����п��ܵ�·������
 * 2. ��x[i] = 0, f[i] = f[i - 1] + f[i], f[0] = 1; ��x[i] = 1, f[i] = 0; f[0] = 0 ->
 *    ÿһ��λ�õ��ڴ�������ʹ��ϱ����Ŀ��ܵĺ�, ÿһ��ĵ�һ��λ�ÿ�����Ϊ1; �����λ����obstacle, �򲻹�����·�������Զ�Ϊ0
 * 3. �ڵ�һ�㣬 ��x[i] = 0, ÿһ��λ��f[i] = 1; ��x[i] = 1, ���Ժ�����f[i] = 0 ->
 *    �ڵ�һ�㣬ÿ��λ�õĿ����Զ�ֻΪ1, �����obstacle��������е�λ�ö���������㵽��
 *    ����ÿһ��ĵ�һ��λ�ö�Ϊ1, ���ĳһ�㿪ʼ��һ��λ����obstacle,��������в�ĵ�һ��λ�ö�Ϊ0
 * 4. �������һ���f[n - 1] -> �������һ������һ��λ�õ�ֵ
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
            	// ��һ��ֻҪ����obstacle���Ǻ������ж�Ϊ0
                path[i] = 1;
            } else {
                break;
            }
        }
        for (int k = 1; k < m; k++) {
        	// �������ÿһ����ʼλ�ã� ֻҪ��һ����0����������Ƕ��ٶ���0����һ����1�������һ����obstacle����ҲΪ0
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
