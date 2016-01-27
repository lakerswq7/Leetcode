package array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> rst = new ArrayList<Integer>();
        if ((matrix == null) || (matrix.length == 0) || (matrix[0].length == 0)) {
            return rst;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i <= Math.min(m, n) - i - 1; i++) {
            process(rst, matrix, i, m - i - 1, n - i - 1);
        }
        return rst;
    }
    public void process(List<Integer> rst, int[][] matrix, int start, int rowEnd, int colEnd) {
        for (int i = start; i <= colEnd; i++) {
            rst.add(matrix[start][i]);
        }
        if (start == rowEnd) {
            return;
        }
        for (int i = start + 1; i <= rowEnd; i++) {
            rst.add(matrix[i][colEnd]);
        }
        if (start == colEnd) {
            return;
        }
        for (int i = colEnd - 1; i >= start; i--) {
            rst.add(matrix[rowEnd][i]);
        }
        for (int i = rowEnd - 1; i > start; i--) {
            rst.add(matrix[i][start]);
        }
    }
    public static void main(String[] args) {
    	int[][] matrix = new int[0][1];
    	SpiralMatrix sol = new SpiralMatrix();
    	sol.spiralOrder(matrix);
    }
}
