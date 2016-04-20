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
You may assume that row1 ≤ row2 and col1 ≤ col2.
 */
/*
 * 这实际上也是一种tradeoff
 * update的时间为O(n)
 * sumRegion的时间为O(m)
 * 如果要更好的时间复杂度，则需要二维的segment tree了
 * 基本思路就是把整个数组分为四个部分，实际上也是divide and conque的思路
 * 只不过原来就是在线上二分，而现在要在面上四分。每一个节点都有四个边界的值
 * 代码就比较复杂了
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