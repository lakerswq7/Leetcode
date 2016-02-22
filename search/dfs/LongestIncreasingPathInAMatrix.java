package search.dfs;

import java.util.LinkedList;
import java.util.Queue;

public class LongestIncreasingPathInAMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] cache = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, getPath(matrix, cache, m, n, i, j, Integer.MIN_VALUE));
            }
        }
        return max;
    }
    private int getPath(int[][] matrix, int[][] cache, int m, int n, int x, int y, int last) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return 0;
        }
        if (last >= matrix[x][y]) {
            return 0;
        }
        if (cache[x][y] != 0) {
            return cache[x][y];
        }
        int left = getPath(matrix, cache, m, n, x, y - 1, matrix[x][y]);
        int right = getPath(matrix, cache, m, n, x, y + 1, matrix[x][y]);
        int up = getPath(matrix, cache, m, n, x - 1, y, matrix[x][y]);
        int down = getPath(matrix, cache, m, n, x + 1, y, matrix[x][y]);
        
        cache[x][y] = Math.max(left, Math.max(right, Math.max(up, down))) + 1;
        return cache[x][y];
    }
    
    // BFS的解法，实际就是topological sort
    static int[] iX = {-1, 1, 0, 0};
    static int[] iY = {0, 0, 1, -1};
    public int longestIncreasingPath2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] input = initiale(matrix);
        Queue<Pair> queue = new LinkedList<Pair>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (input[i][j] == 0) {
                    queue.offer(new Pair(i, j));
                }
            }
        }
        int round = 0;
        while (queue.size() != 0) {
            round++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair p = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int newX = p.x + iX[k];
                    int newY = p.y + iY[k];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                        if (matrix[p.x][p.y] < matrix[newX][newY]) {
                            input[newX][newY]--;
                            if (input[newX][newY] == 0) {
                                queue.offer(new Pair(newX, newY));
                            }
                        }
    
                    }
                }
            }
        }
        return round;
    }
    static int[][] initiale(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] input = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    int newX = i + iX[k];
                    int newY = j + iY[k];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                        if (matrix[i][j] > matrix[newX][newY]) {
                            input[i][j]++;
                        }
                    }   
                }
            }
        }
        return input;
    }
    class Pair {
        int x, y;
        Pair (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
