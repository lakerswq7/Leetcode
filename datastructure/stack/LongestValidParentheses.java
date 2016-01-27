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
                    // ���ջ���վ�����һ����ջ�ıȽϣ�������֮������ж���Ч
                    // ���ջ�գ������¼�Ŀ��ܵ���Ч��ʼλ�Ƚ�
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
