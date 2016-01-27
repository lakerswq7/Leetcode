package array;

public class RotateImage {
    public void rotate(int[][] matrix) {
        if ((matrix == null) || (matrix.length == 0) || (matrix[0].length == 0)) {
            return;
        }
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            process(matrix, i, n - i - 1);
        }
    }
    public void process(int[][] matrix, int start, int end) {
        int temp;
        for (int i = 0; i < end - start; i++) {
            temp = matrix[start][start + i];
            matrix[start][start + i] = matrix[end - i][start];
            matrix[end - i][start] = matrix[end][end - i];
            matrix[end][end - i] = matrix[start + i][end];
            matrix[start + i][end] = temp;
        }
    }
}
