package datastructure.deque;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        ArrayList<Integer> rst = new ArrayList<Integer>();
        Deque<Integer> deque = new ArrayDeque<Integer>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(nums[i]);
            if (i >= k && nums[i - k] == deque.peekFirst()) {
                deque.pollFirst();
            }
            if (i >= k - 1) {
                rst.add(deque.peekFirst());
            }
        }
        int[] max = new int[nums.length - k + 1];
        for (int i = 0; i < max.length; i++) {
            max[i] = rst.get(i);
        }
        return max;
    }
}
