package array;

public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        int cur = m + n - 1;
        while ((m > 0) && (n > 0)) {
            if (A[m - 1] > B[n - 1]) {
                A[cur] = A[m - 1];
                m--;
            } else {
                A[cur] = B[n - 1];
                n--;
            }
            cur--;
        }
        if (m == 0) {
            while (n > 0) {
                A[cur] = B[n - 1];
                n--;
                cur--;
            }
        }
    }
}
