package search.dfs;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> rst = new ArrayList<List<String>>();
        if (n <= 0) {
            return rst;
        }
        solve(rst, new int[n], 0);
        return rst;
    }
    private void solve(List<List<String>> rst, int[] board, int pos) {
        if (pos >= board.length) {
            draw(rst, board);
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (isValid(board, i, pos)) {
                board[pos] = i;
                solve(rst, board, pos + 1);
            }
        }
    }
    private boolean isValid(int[] board, int num, int pos) {
        for (int i = 0; i < pos; i++) {
            if (board[i] == num || Math.abs(board[i] - num) == Math.abs(i - pos)) {
                return false;
            }
        }
        return true;
    }
    private void draw(List<List<String>> rst, int[] board) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < board.length; j++) {
                if (board[i] == j) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            list.add(sb.toString());
        }
        rst.add(list);
    }
}
