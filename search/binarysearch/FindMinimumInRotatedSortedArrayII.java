package search.binarysearch;

public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] num) {
        if (num == null) {
            return 0;
        }
        int low = 0;
        int high = num.length - 1;
        int mid;
        while (low + 1 < high) {
            mid = low + (high - low) / 2;
            if (num[mid] == num[high]) {
                high--;
            } else if (num[mid] > num[high]) {
                low = mid;
            } else {
                high = mid;
            }
        }
        if (num[low] > num[high]) {
            return num[high];
        }
        return num[0];
    }
}
