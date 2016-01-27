package datastructure.stack;

import java.util.Stack;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null) {
            return 0;
        }
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int validBegin = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (stack.empty()) {
                    validBegin = i + 1;
                } else {
                    stack.pop();
                    // 如果栈不空就与上一次入栈的比较，表明这之后的所有都有效
                    // 如果栈空，就与记录的可能的有效起始位比较
                    if (stack.empty()) {
                        max = Math.max(max, i - validBegin + 1);
                    } else {
                        max = Math.max(max, i - stack.peek());
                    }
                }
            }
        }
        return max;
    }
}
