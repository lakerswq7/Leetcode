package math;

public class SelfCrossing {
	/*
	 * 就三种cross的情况
	 * 1. 从里面穿
	 * 2. 从外面穿
	 * 3. 第五条线和第一条线首尾相接
	 */
    public boolean isSelfCrossing(int[] x) {
        for (int i = 3; i < x.length; i++) {
            if (i == 4 && x[i] + x[i - 4] == x[i - 2] && x[i - 1] == x[i - 3]) {
                return true;
            }
            if (x[i] >= x[i - 2] && x[i - 1] <= x[i - 3]) {
                return true;
            }
            if (i >= 5 && x[i] + x[i - 4] >= x[i - 2] && x[i - 2] >= x[i - 4] && x[i - 1] <= x[i - 3] && x[i - 1] + x[i - 5] >= x[i - 3]) {
                return true;
            }
        }
        return false;
    }
}
