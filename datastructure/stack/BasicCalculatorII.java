package datastructure.stack;

import java.util.Stack;

public class BasicCalculatorII {
/*
 * ¼Ó¼õ³Ë³ý£¬ ²»´øÀ¨ºÅ
 */
    public int calculate(String s) {
        int result = 0, temp = 0, num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
                if (i == s.length() - 1 || !Character.isDigit(s.charAt(i + 1))) {
                    switch (sign) {
                        case '+': result += temp; temp = num; break;
                        case '-': result += temp; temp = -num; break;
                        case '*': temp *= num; break;
                        case '/': temp /= num; break;
                    }
                    num = 0;
                }
            } else if (c != ' ') {
                sign = c;
            }
        }
        result += temp;
        return result;
    }
/*
 * ¼Ó¼õ³Ë³ý£¬´øÀ¨ºÅ
 */
    public int calculate2(String s) {
        int result = 0, temp = 0, num = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Character> operator = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c) || c == ')') {
                if (c == ')') {
                    num = result + temp;
                    temp = stack.pop();
                    result = stack.pop();
                    sign = operator.pop();
                } else {
                    num = num * 10 + c - '0';
                }
                
                if (i == s.length() - 1 || !Character.isDigit(s.charAt(i + 1)) || c == ')') {
                    switch (sign) {
                        case '+': result += temp; temp = num; break;
                        case '-': result += temp; temp = -num; break;
                        case '*': temp *= num; break;
                        case '/': temp /= num; break;
                    }
                    num = 0;
                }
            } else if (c == ' ') {
                continue;
            } else if (c == '(') {
                stack.push(result);
                stack.push(temp);
                operator.push(sign);
                result = 0;
                temp = 0;
                sign = '+';
            } else {
                sign = c;
            }
        }
        result += temp;
        return result;
    }
}
