package search.dfs;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if ((board == null) || (word == null) || (board.length == 0) || (board[0].length == 0) || (word.length() == 0)) {
            return false;
        }
        int index = 0;
        boolean visited[][] = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (matchWord(board, word, visited, index, i, j) == true) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean matchWord(char[][] board, String word, boolean[][] visited, int index, int x, int y) {
        if ((x < 0) || (x >= board.length) || (y < 0) || (y >= board[0].length)) {
            return false;
        }
        if (board[x][y] != word.charAt(index) || visited[x][y] == true) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        visited[x][y] = true;
        boolean match = matchWord(board, word, visited, index + 1, x + 1, y) || matchWord(board, word, visited, index + 1, x - 1, y) || matchWord(board, word, visited, index + 1, x, y + 1) || matchWord(board, word, visited, index + 1, x, y - 1);
        visited[x][y] = false;
        return match;
    }
}
