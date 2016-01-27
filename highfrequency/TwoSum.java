package highfrequency;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int[] index = new int[2];
        if ((numbers == null) || (numbers.length < 2)) {
            return index;
        }
        HashMap<Integer, Integer> diff = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            diff.put(target - numbers[i], i);
        }
        for (int i = 0; i < numbers.length; i++) {
            if (diff.containsKey(numbers[i])) {
                int ind = diff.get(numbers[i]);
                if (i > ind) {
                    index[0] = ind + 1;
                    index[1] = i + 1;
                } else if (i < ind) {
                    index[0] = i + 1;
                    index[1] = ind + 1;
                }
            }
        }
        return index;
    }
}
