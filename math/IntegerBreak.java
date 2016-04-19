package math;

public class IntegerBreak {
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int count = n / 3;
        int mod = n % 3;
        int rst = 1;
        if (mod == 0) {
            rst = (int)Math.pow(3, count);
        } else if (mod == 1) {
            rst = (int)Math.pow(3, count - 1) * 4;
        } else {
            rst = (int)Math.pow(3, count) * 2;
        }
        return rst;
    }
}
