package search.binarysearch;

public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int A[], int B[]) {
        int len = A.length + B.length;
        // �鿴��ż�ԣ����ż���Ļ�ȡ�м������ͳ�2�����������ȡ�м��Ǹ���
        if (len % 2 == 0) {
            return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2.0;
        } else {
            return findKth(A, 0, B, 0, len / 2 + 1);
        }
    }
	/*
	 * �ҵ�KС�������������K���� (A.length + B.length) / 2 ������
	 */
    public int findKth(int A[], int startA, int B[], int startB, int k) {
    	// �����һ��array�Ѿ�ȡ���ˣ��Ǿʹ���һ�����Ҿ����ˡ�ͬʱҲ��ֹ��ʼ��ʱ��A����B�ĳ���Ϊ0�����
        if (startA >= A.length) {
            return B[startB + k - 1];
        }
        if (startB >= B.length) {
            return A[startA + k - 1];
        }
        // �߽��������������С���Ǹ����ǾͱȽ�����array�ĵ�һ����������
        if (k == 1) {
            return Math.min(A[startA], B[startB]);
        }
        // ����Ѿ�����Χ�ˣ��ǾͰ���һ��array��ǰ K / 2 ����ȥ�������ˣ������ø������ֵ��������֤һ������������һ��array
        int keyA = (startA + k / 2 - 1) < A.length ? A[startA + k / 2 - 1] : Integer.MAX_VALUE;
        int keyB = (startB + k / 2 - 1) < B.length ? B[startB + k / 2 - 1] : Integer.MAX_VALUE;
        // �ĸ�С���Ͱ���ǰ K / 2 ����ȥ��
        if (keyA > keyB) {
            return findKth(A, startA, B, startB + k / 2, k - k / 2);
        } else {
            return findKth(A, startA + k / 2, B, startB, k - k / 2);
        }
    }
}
