package search.binarysearch;

public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int A[], int B[]) {
        int len = A.length + B.length;
        // 查看奇偶性，如果偶数的话取中间两数和除2，如果奇数就取中间那个数
        if (len % 2 == 0) {
            return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2.0;
        } else {
            return findKth(A, 0, B, 0, len / 2 + 1);
        }
    }
	/*
	 * 找第K小的数，在这里吧K赋成 (A.length + B.length) / 2 就行了
	 */
    public int findKth(int A[], int startA, int B[], int startB, int k) {
    	// 如果有一个array已经取完了，那就从另一个里找就行了。同时也防止初始的时候A或者B的长度为0的情况
        if (startA >= A.length) {
            return B[startB + k - 1];
        }
        if (startB >= B.length) {
            return A[startA + k - 1];
        }
        // 边界条件，如果找最小的那个，那就比较两个array的第一个数就行了
        if (k == 1) {
            return Math.min(A[startA], B[startB]);
        }
        // 如果已经超范围了，那就把另一个array的前 K / 2 个数去掉就行了，这里用赋成最大值来处理，保证一定消掉的是另一个array
        int keyA = (startA + k / 2 - 1) < A.length ? A[startA + k / 2 - 1] : Integer.MAX_VALUE;
        int keyB = (startB + k / 2 - 1) < B.length ? B[startB + k / 2 - 1] : Integer.MAX_VALUE;
        // 哪个小，就把它前 K / 2 个数去掉
        if (keyA > keyB) {
            return findKth(A, startA, B, startB + k / 2, k - k / 2);
        } else {
            return findKth(A, startA + k / 2, B, startB, k - k / 2);
        }
    }
}
