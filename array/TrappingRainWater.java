package array;

public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int right = 0;
        int[] left = new int[height.length];
        left[0] = height[0];
        int water = 0;
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }
        
        for (int i = height.length - 1; i >= 0; i--) {
            right = Math.max(right, height[i]);
            water += Math.min(left[i], right) - height[i];
        }
        return water;
    }
}
