package string;

import java.util.Arrays;
/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to determine if a number is strobogrammatic. The number is represented as a string.

For example, the numbers "69", "88", and "818" are all strobogrammatic.
 *
 */
public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        int[] array = new int[10];
        Arrays.fill(array, -1);
        array[0] = 0;
        array[1] = 1;
        array[6] = 9;
        array[9] = 6;
        array[8] = 8;
        int s = 0, e = num.length() - 1;
        while (s <= e) {
            if (array[num.charAt(s) - '0'] != num.charAt(e) - '0') {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
}
