package array;

public class MaximumProductSubarray {
    public int maxProduct(int[] A) {
        if ((A == null) || (A.length == 0)) {
            return 0;
        }
        if (A.length == 1) {
            return A[0];
        }
        int pos = 0;
        int neg = 0;
        int max = 0;
        int temp;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0) {
                pos = Math.max(pos * A[i], A[i]);
                neg = neg * A[i];
                max = Math.max(pos, max);
            } else {
                temp = pos;
                pos = neg * A[i];
                neg = Math.min(temp * A[i], A[i]);
                max = Math.max(pos, max);
            }
            System.out.println(pos + " " + neg);
        }
        return max;
    }
    public static void main(String[] args) {
    	int[] a = {-4, -3};
    	MaximumProductSubarray sol = new MaximumProductSubarray();
    	System.out.println(sol.maxProduct(a));
    }
}
