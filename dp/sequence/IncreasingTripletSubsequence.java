package dp.sequence;

import java.util.Arrays;

public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int[] array = new int[2];
        Arrays.fill(array, Integer.MAX_VALUE);
        for (int n : nums) {
            if (n <= array[0]) {
                array[0] = n;
            } else if (n <= array[1]) {
                array[1] = n;
            } else {
                return true;
            }
        }
        return false;
    }
}
