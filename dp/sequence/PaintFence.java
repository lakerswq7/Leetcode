package dp.sequence;

/**
 * There is a fence with n posts, each post can be painted with one of the k colors.

You have to paint all the posts such that no more than two adjacent fence posts have the same color.

Return the total number of ways you can paint the fence.

Note:
n and k are non-negative integers.
 */
public class PaintFence {
    public int numWays(int n, int k) {
        if (n == 0 || k == 0) {
            return 0;
        }
        int noDu = k;
        int du = 0;
        for (int i = 1; i < n; i++) {
            int temp = du;
            du = noDu;
            noDu = (temp + noDu) * (k - 1);
        }
        return du + noDu;
    }
}
