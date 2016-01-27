package math;

public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        if (n <= 0) {
            return 0;
        }
        int sum = 0;
        while (n > 0) {
            n = n / 5;
            sum += n;
        }
        return sum;
    }
}
