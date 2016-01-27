package highfrequency;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        if ((num == null) || (num.length < 3)) {
            return 0;
        }
        Arrays.sort(num);
        int closest = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < num.length - 2; i++) {
            int left = i + 1;
            int right = num.length - 1;
            while (left < right) {
                int sum = num[i] + num[left] + num[right];
                int temp = Math.abs(sum - target);
                if (temp < diff) {
                    diff = temp;
                    closest = sum;
                }
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    return target;
                }
            }
        }
        return closest;
    }
}
