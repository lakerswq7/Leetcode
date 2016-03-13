package datastructure.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TheSkylineProblem {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> rst = new ArrayList<int[]>();
        int[][] wall = new int[buildings.length * 2][2];
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(1, Collections.reverseOrder());
        for (int i = 0; i < buildings.length; i++) {
            wall[2 * i][0] = buildings[i][0];
            wall[2 * i][1] = buildings[i][2];
            wall[2 * i + 1][0] = buildings[i][1];
            wall[2 * i + 1][1] = -buildings[i][2];
        }
        Arrays.sort(wall, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return b[1] - a[1];
                }
                return a[0] - b[0];
            }
        });
        heap.offer(0);
        for (int[] w : wall) {
            if (w[1] > 0) {
                if (w[1] > heap.peek()) {
                    rst.add(new int[]{w[0], w[1]});
                }
                heap.offer(w[1]);
            } else {
                heap.remove(-w[1]);
                if (-w[1] > heap.peek()) {
                    rst.add(new int[]{w[0], heap.peek()});
                }
            }
        }
        return rst;
    }
}
