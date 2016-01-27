package search.dfs;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        if (board == null) {
            return;
        }
        boolean[][][] visited = new boolean[3][9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int index = board[i][j] - '1';
                    visited[0][i][index] = true;
                    visited[1][j][index] = true;
                    visited[2][i - (i % 3) + (j / 3)][index] = true;
                }
            }
        }
        fillBoard(visited, board, 0, 0);
    }
    public boolean fillBoard(boolean[][][] visited, char[][] board, int x, int y) {
        if (x == 9) {
            return true;
        }
        if (!(board[x][y] == '.')) {
            return fillBoard(visited, board, x + (y + 1) / 9, (y + 1) % 9);
        }
        for (int i = 0; i < 9; i++) {
            if (isValid(visited, x, y, i)) {
                board[x][y] = (char)(i + '1');
                visited[0][x][i] = true;
                visited[1][y][i] = true;
                visited[2][x - (x % 3) + (y / 3)][i] = true;
                if (fillBoard(visited, board, x + (y + 1) / 9, (y + 1) % 9)) {
                    return true;
                }
                visited[0][x][i] = false;
                visited[1][y][i] = false;
                visited[2][x - (x % 3) + (y / 3)][i] = false;
                board[x][y] = '.';
            }
        }
        return false;
    }
    public boolean isValid(boolean[][][] visited, int x, int y, int i) {
        if (visited[0][x][i] || visited[1][y][i] || visited[2][x - (x % 3) + (y / 3)][i]) {
            return false;
        }
        return true;
    }
}
