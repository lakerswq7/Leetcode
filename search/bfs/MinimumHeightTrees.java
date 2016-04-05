package search.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumHeightTrees {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> rst = new ArrayList<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        int count = 0;
        int[] connect = new int[n];
        ArrayList<ArrayList<Integer>> neighboor = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            neighboor.add(new ArrayList<Integer>());
        }
        for (int[] e : edges) {
            connect[e[0]]++;
            connect[e[1]]++;
            neighboor.get(e[0]).add(e[1]);
            neighboor.get(e[1]).add(e[0]);
        }
        for (int i = 0; i < n; i++) {
            if (connect[i] == 1 || connect[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            if (n - count <= 2) {
                break;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                count++;
                for (int nei : neighboor.get(cur)) {
                    connect[nei]--;
                    if (connect[nei] == 1) {
                        queue.offer(nei);
                    }
                }
            }
        }
        while (!queue.isEmpty()) {
            rst.add(queue.poll());
        }
        return rst;
    }
}
