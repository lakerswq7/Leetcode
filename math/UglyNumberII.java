package math;

import java.util.ArrayList;

public class UglyNumberII {
    public int nthUglyNumber(int n) {
        ArrayList<Integer> ugly = new ArrayList<Integer>();
        if (n == 1) {
            return 1;
        }
        ugly.add(1);
        int count2 = 0, count3 = 0, count5 = 0;
        while (ugly.size() < n) {
            int cur = Math.min(Math.min(ugly.get(count2) * 2, ugly.get(count3) * 3), ugly.get(count5) * 5);
            ugly.add(cur);
            if (ugly.get(count2) * 2 == cur) {
                count2++;
            }
            if (ugly.get(count3) * 3 == cur) {
                count3++;
            }
            if (ugly.get(count5) * 5 == cur) {
                count5++;
            }
        }
        return ugly.get(ugly.size() - 1);
    }
}
