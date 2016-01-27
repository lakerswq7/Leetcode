package array;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] A) {
        int length = 0;
        for (int i = 0; i < A.length; i++) {
            if (i == A.length - 1) {
                A[length] = A[i];
                length++;
            } else if (A[i] != A[i + 1]) {
                A[length] = A[i];
                length++;
            }
        }
        return length;
    }
}
