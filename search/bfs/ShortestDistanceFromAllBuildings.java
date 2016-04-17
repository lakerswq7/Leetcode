package search.bfs;

import java.util.LinkedList;
import java.util.Queue;
/**
 * You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:

Each 0 marks an empty land which you can pass by freely.
Each 1 marks a building which you cannot pass through.
Each 2 marks an obstacle which you cannot pass through.
For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):

1 - 0 - 2 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0
The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.

Note:
There will be at least one building. If it is not possible to build such house according to the above rules, return -1.
 */
public class ShortestDistanceFromAllBuildings {
	public int shortestDistance(int[][] grid) {
        int[][] distance = new int[grid.length][grid[0].length];
        int count = 0;
        int[][] access = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    bfs(grid, distance, i, j, access);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    if (access[i][j] == count) {
                        min = Math.min(min, distance[i][j]);
                    }
                }
            }
        }
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }
    int[] iX = new int[]{0, 0, 1, -1};
    int[] iY = new int[]{1, -1, 0, 0};
    private void bfs(int[][] grid, int[][] distance, int x, int y, int[][] access) {
        Queue<Pair> queue = new LinkedList<Pair>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        queue.offer(new Pair(x, y));
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                Pair cur = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int newX = iX[i] + cur.x;
                    int newY = iY[i] + cur.y;
                    if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == 0 && !visited[newX][newY]) {
                        access[newX][newY]++;
                        visited[newX][newY] = true;
                        distance[newX][newY] += level;
                        queue.offer(new Pair(newX, newY));
                    }
                }
            }
            level++;
        }
    }
    class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}