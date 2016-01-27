package search.binarysearch;

public class SearchInRotatedSortedArray {
	public int search(int[] A, int target) {
        if ((A == null) || (A.length == 0)) {
            return -1;  
        }
        int low = 0;
        int high = A.length - 1;
        int mid;
        while (low + 1 < high) {
            mid = low + (high - low) / 2;
            if (A[mid] == target) {
                return mid;
            }
            if (A[mid] > A[low]) {
            	// 注意这里的等号代表，如果要在前半边，target也可能等于A[low]
               if ((A[mid] > target) && (A[low] <= target)) {
                   high = mid;
               } else {
                   low = mid;
               }
            } else {
            	// 注意这里的等号代表，如果要在后半边，target也可能等于A[high]
                if ((A[mid] < target) && (A[high] >= target)) {
                    low = mid;
                } else {
                    high = mid;
                }
            }
        }
        
        if (A[low] == target) {
            return low;
        }
        if (A[high] == target) {
            return high;
        }
        return -1;
    }
}
