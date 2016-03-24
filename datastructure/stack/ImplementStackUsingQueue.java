package datastructure.stack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {
	class MyStack {
	    // Push element x onto stack.
	    Queue<Integer> queue = new LinkedList<Integer>();
	    public void push(int x) {
	        int size = queue.size();
	        queue.offer(x);
	        while (size-- > 0) {
	            queue.offer(queue.poll());
	        }
	    }

	    // Removes the element on top of the stack.
	    public void pop() {
	        queue.poll();
	    }

	    // Get the top element.
	    public int top() {
	        return queue.peek();
	    }

	    // Return whether the stack is empty.
	    public boolean empty() {
	        return queue.isEmpty();
	    }
	}
}
