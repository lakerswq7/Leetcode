package dp.sequence;

public class HouseRobber {
    public int rob(int[] num) {
        int n = num.length;
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return num[0];
        } else if (n == 2) {
            return Math.max(num[0], num[1]);
        }
        int[] money = new int[n];
        money[0] = 0;
        money[1] = num[0];
        
        for (int i = 2; i < n; i++) {
            money[i] = Math.max(money[i - 1], money[i - 2] + num[i - 1]);
        }
        return Math.max(money[n - 1], money[n - 2] + num[n - 1]);
    }
}
