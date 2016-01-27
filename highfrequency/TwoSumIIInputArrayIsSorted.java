package highfrequency;

public class TwoSumIIInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum > target) {
                high--;
            } else if (sum < target) {
                low++;
            } else {
                result[0] = low + 1;
                result[1] = high + 1;
                break;
            }
        }
        return result;
    }
}
