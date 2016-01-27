package datastructure.stack;

import java.util.Stack;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] height = new int[n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                height[j] = matrix[i][j] == '1' ? height[j] + 1 : 0;
            }
            max = Math.max(max, maxArea(height));
        }
        return max;
    }
    public int maxArea(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i <= height.length; i++) {
            int num = i == height.length ? -1 : height[i];
            while (!stack.empty() && height[stack.peek()] > num) {
                int high = height[stack.pop()];
                int left = stack.empty() ? -1 : stack.peek();
                max = Math.max(max, (i - left - 1) * high);
            }
            stack.push(i);
        }
        return max;
    }
}
