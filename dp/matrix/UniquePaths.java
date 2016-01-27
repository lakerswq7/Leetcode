package dp.matrix;
/*
 * matrix dp������ͨ���Ż�ɨ��˳���С�ռ��ʹ��
 * 0. ��������, �����п��ܵ�·������, matrix -> dp
 * 1. f[i] -> ����㵽��ǰ��һ��ÿһ��λ�����п��ܵ�·������
 * 2. f[i] = f[i - 1] + f[i]; f[0] = 1 -> ÿһ��λ�õ��ڴ�������ʹ��ϱ����Ŀ��ܵĺ�; ÿһ��ĵ�һ��λ�õĿ���Ϊ1
 * 3. �ڵ�һ�㣬 ÿһ��λ��f[i] = 1 -> �ڵ�һ�㣬ÿ��λ�õĿ����Զ�ֻΪ1,����ÿһ��ĵ�һ��λ�ö�Ϊ1
 * 4. �������һ���f[n - 1] -> �������һ������һ��λ�õ�ֵ
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
