package datastructure.stack;

import java.util.Stack;

class MinStack {
    private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();
    public void push(int x) {
        stack.push(x);
        if (minStack.empty() || (x <= getMin())) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (stack.pop().equals(getMin())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}