package search.binarysearch;

public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        if ((A == null) || (A.length == 0)) {
            return 0;
        }
        int low = 0;
        int high = A.length - 1;
        int mid;
        while (low + 1 < high) {
            mid = low + (high - low) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] > target) {
                high = mid;
            } else if (A[mid] < target) {
                low = mid;
            }
        }
        
        if (A[low] >= target) {
            return low;
        }
        if (A[high] == target) {
            return high;
        }
        if (A[high] < target) {
            return high + 1;
        }
        
        return low  + 1;
    }
}
