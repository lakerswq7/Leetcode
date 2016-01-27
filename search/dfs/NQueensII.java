package search.dfs;

import java.util.ArrayList;

public class NQueensII {
	private int count = 0;
    public int totalNQueens(int n) {
        count = 0;
        solQueens(new ArrayList<Integer>(), n);
        return count;
    }
    public void solQueens(ArrayList<Integer> list, int n) {
        if (list.size() == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (noAttack(list, i)) {
                list.add(i);
                solQueens(list, n);
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
}
