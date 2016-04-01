package array;

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int live = countLive(board, i, j);
                if (board[i][j] == 1) {
                    if (live >= 2 && live <= 3) {
                        board[i][j] += 2;
                    }
                } else {
                    if (live == 3) {
                        board[i][j] += 2;
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = board[i][j] >> 1;
            }
        }
    }
    private int countLive(int[][] board, int x, int y) {
        int m = board.length;
        int n = board[0].length;
        int count = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && i < m && j >= 0 && j < n && !(i == x && j == y)) {
                    count += board[i][j] & 1;
                }
            }
        }
        return count;
    }
}
