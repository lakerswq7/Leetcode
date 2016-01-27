package math;

public class StringToInteger {
    public int atoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        int sign = 1;
        int index = 0;
        if (str.charAt(index) == '-') {
            sign = -1;
            index++;
        } else if (str.charAt(index) == '+') {
            index++;
        }
        long num = 0;
        while (index < str.length()) {
            char s = str.charAt(index);
            if ((s < '0') || (s > '9')) {
                break;
            }
            num = num * 10 + s - '0';
            if (num > Integer.MAX_VALUE) {
                break;
            }
            index++;
        }
        num = num * sign;
        if (num > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (num < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int)num;
    }
}
