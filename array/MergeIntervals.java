package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> rst = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) {
            return rst;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        Interval cur = intervals.get(0);
        for (Interval i : intervals) {
            if (cur.end < i.start) {
                rst.add(cur);
                cur = i;
            } else {
                cur.end = Math.max(cur.end, i.end);
            }
        }
        rst.add(cur);
        return rst;
    }
}
