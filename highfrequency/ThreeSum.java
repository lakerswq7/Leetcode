package highfrequency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if ((num == null) || (num.length < 3)) {
            return result;
        }
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            if ((i != 0) && (num[i] == num[i - 1])) {
                continue;
            }
            int left = i + 1;
            int right = num.length - 1;
            while (left < right) {
                if (num[left] + num[right] > -num[i]) {
                    right--;
                } else if (num[left] + num[right] < -num[i]) {
                    left++;
                } else {
                    ArrayList<Integer> sum = new ArrayList<Integer>();
                    sum.add(num[i]);
                    sum.add(num[left]);
                    sum.add(num[right]);
                    result.add(sum);
                    left++;
                    right--;
                    while ((left < right) && (num[left] == num[left - 1])) {
                        left++;
                    }
                    while ((left < right) && (num[right] == num[right + 1])) {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
