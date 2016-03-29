package dp.sequence;

import java.util.Arrays;

public class PerfectSquares {
    public int numSquares(int n) {
        int[] num = new int[n + 1];
        Arrays.fill(num, Integer.MAX_VALUE);
        for (int i = 1; i * i <= n; i++) {
            int temp = i * i;
            num[temp++] = 1;
            while (temp < (i + 1) * (i + 1) && temp <= n) {
                for (int j = 1; j <= i; j++) {
                    num[temp] = Math.min(num[j * j] + num[temp - j * j], num[temp]);
                }
                temp++;
            }
        }
        return num[n];
    }
}
