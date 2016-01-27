package search.binarysearch;

public class FindPeakElement {
    public int findPeakElement(int[] num) {
        if ((num == null) || (num.length == 0)) {
            return -1;
        }
        int low = 0;
        int high = num.length - 1;
        int mid;
        while (low + 1 < high) {
            mid = low + (high - low) / 2;
            if ((num[mid] > num[mid + 1]) && (num[mid] > num[mid - 1])) {
                return mid;
            }
            if ((num[mid] < num[mid + 1]) && (num[mid] > num[mid - 1])) {
                low = mid;
            } else {
                high = mid;
            }
        }
        if (num[low] < num[high]) {
            return high;
        } else {
            return low;
        }
    }
}
