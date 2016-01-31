package array;

import java.util.Arrays;

public class Candy {
    public int candy(int[] ratings) {
        if ((ratings == null) || (ratings.length == 0)) {
            return 0;
        }
        int[] count = new int[ratings.length];
        int sum = 0;
        Arrays.fill(count, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                count[i] = count[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0 ; i--) {
            if ((ratings[i] > ratings[i + 1]) && (count[i] <= count[i + 1])) {
                count[i] = count[i + 1] + 1;
            }
            sum += count[i];
        }
        sum += count[ratings.length - 1];
        return sum;
    }
}

