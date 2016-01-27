package math;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        long num = 0;
        long tmp = x;
        while (x != 0) {
            num = num * 10 + x % 10;
            x = x / 10;
        }
        if (num > Integer.MAX_VALUE) {
            return false;
        }
        if (num == tmp) {
            return true;
        }
        return false;
    }
}
