package highfrequency;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> rst = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return rst;
        }
        int n1 = 0, n2 = 0, count1 = 0, count2 = 0;
        for (int num : nums) {
            if (count1 != 0 && n1 == num) {
                count1++;
            } else if (count2 != 0 && n2 == num) {
                count2++;
            } else if (count1 == 0) {
                n1 = num;
                count1++;
            } else if (count2 == 0) {
                n2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        if (count1 != 0 && countNum(nums, n1) > nums.length / 3) {
            rst.add(n1);
        }
        if (count2 != 0 && countNum(nums, n2) > nums.length / 3) {
            rst.add(n2);
        }
        return rst;
    }
    private int countNum(int[] nums, int element) {
        int count = 0;
        for (int num : nums) {
            if (num == element) {
                count++;
            }
        }
        return count;
    }
}
