package datastructure.stack;

import java.util.Stack;

/*
 * ֻ��һ�飬ÿ��ǰ���Ǹ����������ջ��ʱ���ʾ������Ϣ
 * 1. ��ǰ�����λ�������ұ߱���С������ĵ�(����ȵ�ʱ���������ұߵ��Ǹ�λ���������ȷ�ģ��м�Ĳ��ԣ��������ұ��Ǹ�����������һ���Ǹ����)
 * 2. ջ��ǰһ��λ��������߱���С������ĵ�
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
