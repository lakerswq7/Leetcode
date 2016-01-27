package math;

public class ValidNumber {
	public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int b = 0;
        int e = s.length() - 1;
        while (b <= e && s.charAt(b) == ' ') {
            b++;
        }
        if (b == e + 1) {
            return false;
        }
        while (s.charAt(e) == ' ') {
            e--;
        }
        if (s.charAt(b) == '+' || s.charAt(b) == '-') {
            b++;
        }
        boolean isNum = false;
        boolean hasDot = false;
        boolean hasExp = false;
        while (b <= e) {
            char cur = s.charAt(b);
            if (Character.isDigit(cur)) {
                isNum = true;
            } else if (cur == '.') {
                if (hasExp || hasDot) {
                    return false;
                }
                hasDot = true;
            } else if (cur == 'e') {
                if (hasExp || !isNum) {
                    return false;
                }
                hasExp = true;
                isNum = false;
            } else if (cur == '+' || cur == '-') {
                if (s.charAt(b - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
            b++;
        }
        return isNum;
    }
}
