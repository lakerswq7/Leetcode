package datastructure.stack;

import java.util.Stack;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<Character>();
        int[] appear = new int[26];
        for (int i = 0; i < s.length(); i++) {
            appear[s.charAt(i) - 'a']++;
        }
        boolean[] visited = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!visited[c - 'a']) {
                while (!stack.isEmpty() && appear[stack.peek() - 'a'] != 0 && stack.peek() > c) {
                    visited[stack.pop() - 'a'] = false;
                }
                stack.push(c);
                visited[c - 'a'] = true;
            }
            appear[c - 'a']--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
