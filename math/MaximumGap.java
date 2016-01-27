package math;

import java.util.Arrays;

public class MaximumGap {
    public int maximumGap(int[] num) {
        if (num == null || num.length < 2) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int e : num) {
            max = Math.max(max, e);
            min = Math.min(min, e);
        }
        int len = (max - min) / (num.length - 1) + 1;
        int n = (max - min) / len + 1;
        int[] allMax = new int[n];
        int[] allMin = new int[n];
        Arrays.fill(allMax, Integer.MIN_VALUE);
        Arrays.fill(allMin, Integer.MAX_VALUE);
        
        for (int e : num) {
            int index = (e - min) / len;
            allMax[index] = Math.max(allMax[index], e);
            allMin[index] = Math.min(allMin[index], e);
        }
        
        int gap = allMax[0] - allMin[0];
        int pre = 0;
        for (int i = 0; i < n; i++) {
            if (allMax[i] != Integer.MIN_VALUE) {
                gap = Math.max(allMin[i] - allMax[pre], gap);
                pre = i;
            }
        }
        return gap;
    }
}
