package search.binarysearch;

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if ((matrix == null) || (matrix.length == 0) || (matrix[0].length == 0)) {
            return false;
        }
        int low = 0;
        int cols = matrix[0].length;
        int rows = matrix.length;
        int high = cols * rows - 1;
        int mid, temp;
        
        while (low <= high) {
            mid = low + (high - low) / 2;
            temp = matrix[mid / cols][mid % cols];
            if (temp == target) {
                return true;
            } else if (temp > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
