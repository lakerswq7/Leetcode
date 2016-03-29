package search.binarysearch;

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int low = 1, high = n;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid;
            }
        }
        if (isBadVersion(low)) {
            return low;
        } else {
            return high;
        }
    }
    boolean isBadVersion(int version) {
    	return true;
    }
}
