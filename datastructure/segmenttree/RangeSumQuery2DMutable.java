package datastructure.segmenttree;

/**
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

Range Sum Query 2D
The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

Example:
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
update(3, 2, 2)
sumRegion(2, 1, 4, 3) -> 10
Note:
The matrix is only modifiable by the update function.
You may assume the number of calls to update and sumRegion function is distributed evenly.
You may assume that row1 �� row2 and col1 �� col2.
 */
/*
 * ��ʵ����Ҳ��һ��tradeoff
 * update��ʱ��ΪO(n)
 * sumRegion��ʱ��ΪO(m)
 * ���Ҫ���õ�ʱ�临�Ӷȣ�����Ҫ��ά��segment tree��
 * ����˼·���ǰ����������Ϊ�ĸ����֣�ʵ����Ҳ��divide and conque��˼·
 * ֻ����ԭ�����������϶��֣�������Ҫ�������ķ֡�ÿһ���ڵ㶼���ĸ��߽��ֵ
 * ����ͱȽϸ�����
 */
public class RangeSumQuery2DMutable {
	public class NumMatrix {
	    int[][] sums;
	    int[][] nums;
	    public NumMatrix(int[][] matrix) {
	        if (matrix != null && matrix.length != 0 && matrix[0].length != 0) {
	            int m = matrix.length;
	            int n = matrix[0].length;
	            nums = matrix;
	            sums = new int[m][n + 1];
	            for (int i = 0; i < m; i++) {
	                int sum = 0;
	                for (int j = 0; j < n; j++) {
	                    sum += matrix[i][j];
	                    sums[i][j + 1] = sum;
	                }
	            }
	        }
	    }

	    public void update(int row, int col, int val) {
	        int diff = val - nums[row][col];
	        nums[row][col] = val;
	        for (int i = col + 1; i < sums[0].length; i++) {
	            sums[row][i] += diff;
	        }
	    }

	    public int sumRegion(int row1, int col1, int row2, int col2) {
	        int s = 0;
	        for (int i = row1; i <= row2; i++) {
	            s += sums[i][col2 + 1] - sums[i][col1];
	        }
	        return s;
	    }
	}
}

//Your NumMatrix object will be instantiated and called as such:
//NumMatrix numMatrix = new NumMatrix(matrix);
//numMatrix.sumRegion(0, 1, 2, 3);
//numMatrix.update(1, 1, 10);
//numMatrix.sumRegion(1, 2, 3, 4);