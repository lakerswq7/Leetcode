package math;

public class BulbSwitcher {
    public int bulbSwitch(int n) {
        int count = 0;
        while (count * count <= n) {
            count++;
        }
        return count - 1;
    }
}
