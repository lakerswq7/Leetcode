package array;

public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
        if ((gas == null) || (cost == null) || (gas.length == 0) || (cost.length == 0)) {
            return -1;
        }
        int remain = 0;
        int start = 0;
        int total = 0;
        for (int i = 0; i < gas.length; i++) {
            remain += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (remain < 0) {
                start = i + 1;
                remain = 0;
            }
        }
        return total < 0 ? -1 : start;
    }
}
