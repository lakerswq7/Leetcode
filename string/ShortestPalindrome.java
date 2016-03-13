package string;

public class ShortestPalindrome {
	/*
	 * 每次start停住的那个点以及之后都不包括在回文里，需要整体加到前面。但是不能就此确定中间部分就一定是回文，需要递归调用，
	 * 直到确定他自己就是回文为止
	 */
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int start = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(start) == s.charAt(i)) {
                start++;
            }
        }
        if (start == s.length()) {
            return s;
        }
        String suffix = s.substring(start);
        return new StringBuilder(suffix).reverse().toString() + shortestPalindrome(s.substring(0, start)) + suffix;
    }
}
