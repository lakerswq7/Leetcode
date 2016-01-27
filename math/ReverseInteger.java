package math;

public class ReverseInteger {
    public int reverse(int x) {
        long check = 0;
        while (x != 0) {
            check = check * 10 + x % 10;
            x = x / 10;
        }
        if ((check > Integer.MAX_VALUE) || (check < Integer.MIN_VALUE)) {
            return 0;
        }
        return (int)check;
    }
}
