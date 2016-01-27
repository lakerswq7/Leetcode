package array;

public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] A) {
        if (A == null) {
            return 0;
        }
        int len = 0;
        for (int i = 0; i < A.length; i++) {
            if (((A.length - i) <= 2) || (A[i] != A[i + 2])) {
                A[len] = A[i];
                len++;
            }
        }
        return len;
    }
}
