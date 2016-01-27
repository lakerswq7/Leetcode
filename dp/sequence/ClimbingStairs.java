package dp.sequence;
/*
 * 0. �޷���������������ÿ��ܣ� sequence -> dp
 * 1. f[i] -> ������i�׵�ʱ�����п��ܵ����÷�ʽ
 * 2. f[i] = f[i - 1] + f[i - 2] -> ��Ϊһ��ֻ����һ���������������Ծ͵���һ��֮ǰ�����п��ܺ�����֮ǰ�����п���
 * 3. f[0] = 1, f[1] = 1 -> ��0��һ�ֿ��ܣ���һ��һ�ֿ���
 * 4. f[n] -> ����n�׵�ʱ�����Ŀ����ж�����
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if ((n == 0) || (n == 1)) {
            return 1;
        }
        int[] sol = new int[n + 1];
        sol[0] = 1;
        sol[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            sol[i] = sol[i - 1] + sol[i - 2];
        }
        return sol[n];
    }
}
