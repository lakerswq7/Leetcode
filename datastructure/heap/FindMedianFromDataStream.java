package datastructure.heap;

import java.util.PriorityQueue;
import java.util.Comparator;

public class FindMedianFromDataStream {
	class MedianFinder {
	    PriorityQueue<Integer> queue1 = new PriorityQueue<Integer>();
	    PriorityQueue<Integer> queue2 = new PriorityQueue<Integer>(1, new Comparator<Integer>() {
	        public int compare(Integer a, Integer b) {
	            return b - a;
	        }
	    });
	    // Adds a number into the data structure.
	    public void addNum(int num) {
	        if (queue2.isEmpty()) {
	            queue2.offer(num);
	        } else {
	            if (num > queue2.peek()) {
	                queue1.offer(num);
	            } else {
	                queue2.offer(num);
	            }
	        }
	        if (queue1.size() > queue2.size()) {
	            queue2.offer(queue1.poll());
	        }
	        if (queue1.size() < queue2.size() - 1) {
	            queue1.offer(queue2.poll());
	        }
	    }

	    // Returns the median of current data stream
	    public double findMedian() {
	        if (queue2.isEmpty()) {
	            return 0;
	        }
	        if (queue1.size() == queue2.size()) {
	            return ((double)queue1.peek() + queue2.peek()) / 2;
	        }
	        return queue2.peek();
	    }
	};

	// Your MedianFinder object will be instantiated and called as such:
	// MedianFinder mf = new MedianFinder();
	// mf.addNum(1);
	// mf.findMedian();
}
