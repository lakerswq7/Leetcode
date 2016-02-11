package highfrequency;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> comp = new HashMap<Integer, Integer>();
        int[] result = new int[]{0, 0};
        for (int i = 0; i < numbers.length; i++) {
            if (comp.containsKey(numbers[i])) {
                result[0] = comp.get(numbers[i]) + 1;
                result[1] = i + 1;
            } else {
                comp.put(target - numbers[i], i);
            }
        }
        return result;
    }
}
