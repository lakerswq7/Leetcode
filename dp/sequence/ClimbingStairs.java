package dp.sequence;
/*
 * 0. 无法排序，求多少种爬得可能， sequence -> dp
 * 1. f[i] -> 爬到第i阶的时候，所有可能的爬得方式
 * 2. f[i] = f[i - 1] + f[i - 2] -> 因为一次只能爬一步或者两步，所以就等于一步之前的所有可能和两步之前的所有可能
 * 3. f[0] = 1, f[1] = 1 -> 第0阶一种可能，第一阶一种可能
 * 4. f[n] -> 到第n阶的时候爬的可能有多少种
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
