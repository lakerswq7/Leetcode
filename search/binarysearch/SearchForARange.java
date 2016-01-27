package search.binarysearch;

public class SearchForARange {
	public int[] searchRange(int[] A, int target) {
        if ((A == null) || (A.length == 0)) {
            return new int[]{-1, -1};
        }
        int low = 0;
        int high = A.length - 1;
        int mid;
        int[] result = new int[2];
        while (low + 1 < high) {
            mid = low + (high - low) / 2;
            if (A[mid] == target) {
                high = mid;
            } else if (A[mid] > target) {
                high = mid;
            } else if (A[mid] < target) {
                low = mid;
            }
        }
        // 找尽量小的所以先考察前面那个
        if (A[low] == target) {
            result[0] = low;
        } else if (A[high] == target) {
            result[0] = high;
        } else {
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        
        low = 0;
        high = A.length - 1;
        while (low + 1 < high) {
            mid = low + (high - low) / 2;
            if (A[mid] == target) {
                low = mid;
            } else if (A[mid] > target) {
                high = mid;
            } else if (A[mid] < target) {
                low = mid;
            }
        }
        // 找尽量大的所以先考察后面那个
        if (A[high] == target) {
            result[1] = high;
        } else if (A[low] == target) {
            result[1] = low;
        }
        return result;
    }
}
