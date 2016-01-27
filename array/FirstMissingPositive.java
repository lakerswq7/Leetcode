package array;

public class FirstMissingPositive {
	public int firstMissingPositive(int[] A) {
        if (A == null) {
            return 1;
        }
        for (int i = 0; i < A.length; i++) {
            while (A[i] > 0 && A[i] <= A.length && A[A[i] - 1] != A[i]) {
                swap(A, i, A[i] - 1);
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
        return A.length + 1;
    }
	public void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	public static void main(String[] args) {
		int[] a = new int[]{2, 1};
		System.out.println(new FirstMissingPositive().firstMissingPositive(a));
	}
}
