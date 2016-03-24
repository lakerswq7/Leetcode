package datastructure.stack;

import java.util.Stack;
/*
 * Ö»¼Ó¼õ£¬ ´øÀ¨ºÅ
 */
public class BasicCalculator {
    public int calculate(String s) {
        int result = 0, sign = 1, eSign = 1, num = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
                if (i == s.length() - 1 || !Character.isDigit(s.charAt(i + 1))) {
                    result += num * sign;
                    num = 0;
                }
            } else if (c == '+') {
                sign = eSign;
            } else if (c == '-') {
                sign = -eSign;
            } else if (c == '(') {
                stack.push(eSign);
                eSign = sign;
            } else if (c == ')') {
                eSign = stack.pop();
            }
        }
        return result;
    }
}
