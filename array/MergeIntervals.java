package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null) {
            return null;
        }
        List<Interval> rst = new ArrayList<Interval>();
        int n = intervals.size();
        int[] left = new int[n];
        int[] right = new int[n];
        ArrayList<Integer> inter = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            left[i] = intervals.get(i).start;
            right[i] = intervals.get(i).end;
        }
        Arrays.sort(left);
        Arrays.sort(right);
        int l = 0, r = 0;
        while (r < n) {
            if (l < n && left[l] <= right[r]) {
                inter.add(left[l]);
                l++;
            } else {
                if (inter.size() == 1) {
                    rst.add(new Interval(inter.get(0), right[r]));
                }
                inter.remove(inter.size() - 1);
                r++;
            }
        }
        return rst;
    }
}
