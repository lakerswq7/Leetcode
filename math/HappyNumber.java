package math;

import java.util.HashSet;

public class HappyNumber {
    public boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        while (n != 1) {
            n = digitSquare(n);
            if (set.contains(n)) {
                return false;
            } else {
                set.add(n);
            }
        }
        return true;
    }
    public int digitSquare(int s) {
        int r = 0;
        while (s != 0) {
            r += (s % 10) * (s % 10);
            s = s / 10;
        }
        return r;
    }
}
