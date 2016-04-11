package math;

public class SelfCrossing {
	/*
	 * ������cross�����
	 * 1. �����洩
	 * 2. �����洩
	 * 3. �������ߺ͵�һ������β���
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
