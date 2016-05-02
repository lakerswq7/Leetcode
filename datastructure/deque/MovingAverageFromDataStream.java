package datastructure.deque;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

For example,
MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3
 */
public class MovingAverageFromDataStream {
	public class MovingAverage {
	    Queue<Integer> queue;
	    int window;
	    int size;
	    /** Initialize your data structure here. */
	    public MovingAverage(int size) {
	        queue = new LinkedList<Integer>();
	        this.size = size;
	        window = 0;
	    }
	    
	    public double next(int val) {
	        queue.offer(val);
	        window += val;
	        if (queue.size() <= size) {
	            return (double)window / queue.size();
	        } else {
	            window -= queue.poll();
	            return (double)window / size;
	        }
	    }
	}
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */