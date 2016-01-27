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
            	// ע������ĵȺŴ������Ҫ��ǰ��ߣ�targetҲ���ܵ���A[low]
               if ((A[mid] > target) && (A[low] <= target)) {
                   high = mid;
               } else {
                   low = mid;
               }
            } else {
            	// ע������ĵȺŴ������Ҫ�ں��ߣ�targetҲ���ܵ���A[high]
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
