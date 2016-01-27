package search.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
    public void solve(char[][] board) {
        if ((board == null) || (board.length == 0) || (board[0].length == 0)) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        Queue<Pair> queue = new LinkedList<Pair>();
        for (int i = 0; i < m; i++) {
            enqueue(queue, board, i, 0);
            enqueue(queue, board, i, n - 1);
        }
        for (int i = 0; i < n; i++) {
            enqueue(queue, board, 0, i);
            enqueue(queue, board, m - 1, i);
        }
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            enqueue(queue, board, cur.x - 1, cur.y);
            enqueue(queue, board, cur.x + 1, cur.y);
            enqueue(queue, board, cur.x, cur.y + 1);
            enqueue(queue, board, cur.x, cur.y - 1);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'D') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    public void enqueue(Queue<Pair> queue, char[][] board, int x, int y) {
        int m = board.length;
        int n = board[0].length;
        if ((x >= 0) && (x < m) && (y >= 0) && (y < n) && (board[x][y] == 'O')) {
            board[x][y] = 'D';
            queue.offer(new Pair(x, y));
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
