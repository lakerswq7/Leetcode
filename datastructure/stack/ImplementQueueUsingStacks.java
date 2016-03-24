package datastructure.stack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementQueueUsingStacks {
	class MyQueue {
	    Queue<Integer> queue1 = new LinkedList<Integer>();
	    Queue<Integer> queue2 = new LinkedList<Integer>();
	    // Push element x to the back of queue.
	    public void push(int x) {
	        queue1.offer(x);
	    }

	    // Removes the element from in front of queue.
	    public void pop() {
	        peek();
	        queue2.poll();
	    }

	    // Get the front element.
	    public int peek() {
	        if (queue2.isEmpty()) {
	            while (!queue1.isEmpty()) {
	                queue2.offer(queue1.poll());
	            }
	        }
	        return queue2.peek();
	    }

	    // Return whether the queue is empty.
	    public boolean empty() {
	        return queue1.isEmpty() && queue2.isEmpty();
	    }
	}
}
