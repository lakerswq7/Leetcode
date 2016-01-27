package highfrequency;


public class MaximumSubarray {
    public int maxSubArray(int[] A) {
        if ((A == null) || (A.length == 0)) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int temp = 0;
        for (int a : A) {
            max = Math.max(temp + a, max);
            temp = Math.max(temp + a, 0);
        }
        return max;
    }
}
