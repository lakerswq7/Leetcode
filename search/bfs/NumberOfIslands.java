package search.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Pair> queue = new LinkedList<Pair>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    if (visited[i][j]) {
                        continue;
                    } else {
                        count++;
                        queue.offer(new Pair(i, j));
                        visited[i][j] = true;
                        while (!queue.isEmpty()) {
                            Pair pair = queue.poll();
                            enqueue(queue, grid, visited, pair.x - 1, pair.y);
                            enqueue(queue, grid, visited, pair.x, pair.y - 1);
                            enqueue(queue, grid, visited, pair.x + 1, pair.y);
                            enqueue(queue, grid, visited, pair.x, pair.y + 1);
                        }
                    }
                }
            }
        }
        return count;
    }
    public void enqueue(Queue<Pair> queue, char[][] grid, boolean[][] visited, int x, int y) {
        int m = grid.length;
        int n = grid[0].length;
        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1' && visited[x][y] == false) {
            queue.offer(new Pair(x, y));
            visited[x][y] = true;
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
