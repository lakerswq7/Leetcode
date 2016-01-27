package search.dfs;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<String[]> solveNQueens(int n) {
        List<String[]> result = new ArrayList<String[]>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        solQueens(result, list, n);
        return result;
    }
    public void solQueens(List<String[]> result, ArrayList<Integer> list, int n) {
        if (list.size() == n) {
            result.add(draw(list, n));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (noAttack(list, i)) {
                list.add(i);
                solQueens(result, list, n);
                list.remove(list.size() - 1);
            }
        }
    }
    public boolean noAttack(ArrayList<Integer> list, int colPos) {
        int rowPos = list.size(); 
        for (int row = 0; row < list.size(); row++) {
            int col = list.get(row);
            if ((col == colPos) || (Math.abs(row - rowPos) == Math.abs(col - colPos))) {
                return false;
            }
        }
        return true;
    }
    public String[] draw(ArrayList<Integer> queens, int n) {
        String[] board = new String[n];
        for (int i = 0; i < queens.size(); i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == queens.get(i)) {
                    row.append('Q');
                } else {
                    row.append('.');
                }
            }
            board[i] = row.toString();
        }
        return board;
    }
}
