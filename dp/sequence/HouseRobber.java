package dp.sequence;

public class HouseRobber {
    public int rob(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        int rob = num[0];
        int noRob = 0;
        for (int i = 1; i < num.length; i++) {
            int temp = noRob;
            noRob = Math.max(rob, noRob);
            rob = temp + num[i];
        }
        return Math.max(rob, noRob);
    }
}
