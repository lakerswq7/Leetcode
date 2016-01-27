package search.binarysearch;

public class SearchInRotatedSortedArrayII {
    public boolean search(int[] A, int target) {
        if ((A == null) || (A.length == 0)) {
            return false;
        }
        int low = 0;
        int high = A.length - 1;
        int mid;
        
        while (low + 1 < high) {
            mid = low + (high - low) / 2;
            if (A[mid] == target) {
                return true;
            }
            // 这里如果出现这种情况则排除一个不可能的即可
            if (A[mid] == A[low]) {
                low++;
                continue;
            }
            if (A[mid] > A[low]) {
                if ((A[mid] > target) && A[low] <= target) {
                    high = mid;
                } else {
                    low = mid;
                }
            } else if (A[mid] < A[low]) {
                if ((A[mid] < target) && (A[high] >= target)) {
                    low = mid;
                } else {
                    high = mid;
                }
            }
        }
        if ((A[low] == target) || (A[high] == target)) {
            return true;
        }
        return false;
    }
}
