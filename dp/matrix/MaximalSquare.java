package dp.matrix;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;
        int[][] area = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == '1') {
                area[i][0] = 1;
                ans = 1;
            }
        }
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == '1') {
                area[0][j] = 1;
                ans = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    area[i][j] = Math.min(area[i][j - 1], Math.min(area[i - 1][j - 1], area[i - 1][j])) + 1;
                    ans = Math.max(ans, area[i][j]);
                }
            }
        }
        return ans * ans;
    }
}
