package array;

public class TrappingRainWater {
    public int trap(int[] A) {
        int left = 0;
        int right = 0;
        int leftMax[] = new int[A.length];
        int water = 0;
        for (int i = 0; i < A.length; i++) {
            if (left < A[i]) {
                left = A[i];
            }
            leftMax[i] = left;
        }
        
        for (int i = A.length - 1; i >= 0; i--) {
            if (right < A[i]) {
                right = A[i];
            }
            water += Math.min(leftMax[i], right) - A[i];
        }
        return water;
    }
}
