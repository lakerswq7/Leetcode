package math;

public class PowerOfFour {
    public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        }
        return (0x55555555 & num) == num && (num & num - 1) == 0;
    }
}
