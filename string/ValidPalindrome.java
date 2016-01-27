package string;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (!isValid(s.charAt(left))) {
                    left++;
            } else if (!isValid(s.charAt(right))) {
                    right--;
            } else {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                right--;
                left++;
            }
        }
        return true;
    }
    private boolean isValid(char a) {
        if (((a >= 'A') && (a <= 'Z')) || ((a >= 'a') && (a <= 'z')) || ((a >= '0') && (a <= '9'))) {
            return true;
        }
        return false;
    }
}
