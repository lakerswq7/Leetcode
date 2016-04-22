package search.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

For example, given the 2D grid:
INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:
  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
 */
public class WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        int[] iX = new int[]{1, -1, 0, 0};
        int[] iY = new int[]{0, 0, 1, -1};
        Queue<Pair> queue = new LinkedList<Pair>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new Pair(i, j));
                }
            }
        }
        int distance = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair p = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int newX = p.x + iX[k];
                    int newY = p.y + iY[k];
                    if (newX >= 0 && newX < rooms.length && newY >= 0 && newY < rooms[0].length) {
                        if (rooms[newX][newY] == Integer.MAX_VALUE) {
                            rooms[newX][newY] = distance;
                            queue.offer(new Pair(newX, newY));
                        }
                    }
                }
            }
            distance++;
        }
    }
    class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
