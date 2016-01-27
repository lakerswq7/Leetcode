package datastructure.stack;

import java.util.Stack;

/*
 * 只走一遍，每次前面那个更大的数出栈的时候表示两个信息
 * 1. 当前考察的位置是它右边比它小的最近的点(当相等的时候，这里最右边的那个位置算的是正确的，中间的不对，但是最右边那个算出来的面积一定是更大的)
 * 2. 栈中前一个位置是它左边比它小的最近的点
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] height) {
        if ((height == null) || (height.length == 0)) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i <= height.length; i++) {
            int check = (i == height.length) ? -1 : height[i];
            while (!stack.isEmpty() && (height[stack.peek()] >= check)) {
                int high = height[stack.pop()];
                int left = stack.isEmpty() ? -1 : stack.peek();
                int width = i - left - 1;
                max = Math.max(max, high * width);
            }
            stack.push(i);
        }
        return max;
    }
}
