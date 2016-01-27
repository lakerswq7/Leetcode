package datastructure.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LargestNumber {
    public String largestNumber(int[] num) {
        if (num == null) {
            return null;
        }
        PriorityQueue<String> queue = new PriorityQueue<String>(num.length, new LargestNumberComparator());
        for (int n : num) {
            queue.offer(String.valueOf(n));
        }
        StringBuilder sb = new StringBuilder();
        while (queue.size() > 0) {
            sb.append(queue.poll());
        }
        while (sb.length() > 1) {
            if (sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
            } else {
                break;
            }
        }
        return sb.toString();
    }
    class LargestNumberComparator implements Comparator<String> {
        public int compare(String num1, String num2) {
            String temp1 = num1 + num2;
            String temp2 = num2 + num1;
            return -temp1.compareTo(temp2);
        }
    }
}
