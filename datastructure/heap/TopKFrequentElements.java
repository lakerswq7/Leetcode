package datastructure.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> rst = new ArrayList<Integer>();
        for (int n : nums) {
            if (!map.containsKey(n)) {
                map.put(n, 1);
            } else {
                map.put(n, map.get(n) + 1);
            }
        }
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>(k, new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return a.count - b.count;
            }
        });
        for (int key : map.keySet()) {
            queue.offer(new Pair(key, map.get(key)));
            if (queue.size() > k) {
                queue.poll();
            }
        }
        while (!queue.isEmpty()) {
            rst.add(queue.poll().num);
        }
        return rst;
    }
    class Pair {
        int num;
        int count;
        Pair(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
}
