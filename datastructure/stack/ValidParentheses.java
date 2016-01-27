package datastructure.stack;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        if ((s == null) || (s.length() == 0)) {
            return true;
        }
        Stack<Character> stack = new Stack<Character>();
        String left = "({[";
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (left.contains(String.valueOf(cur))) {
                stack.push(cur);
            } else {
                if (stack.empty()) {
                    return false;
                }
                if (isValid(stack.pop(), cur) == false) {
                    return false;
                }
            }
        }
        if (!stack.empty()) {
            return false;
        }
        return true;
    }
    private boolean isValid(char left, char right) {
        return ((left == '(') && (right == ')')) || ((left == '[') && (right == ']')) || ((left == '{') && (right == '}'));
    }
}
