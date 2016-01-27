package math;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if ((divisor == 0) || ((dividend == Integer.MIN_VALUE) && (divisor == -1))) {
            return Integer.MAX_VALUE;
        }
        boolean isNeg = false;
        if (((dividend < 0) && (divisor > 0)) || ((dividend > 0) && (divisor < 0))) {
            isNeg = true;
        }
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int ans = 0;
        while (a >= b) {
            int shift = 0;
            while (a >= (b << shift)) {
                shift++;
            }
            ans += 1 << (shift - 1);
            a = a - (b << (shift - 1));
        }
        return isNeg ? -ans : ans;
    }
}
