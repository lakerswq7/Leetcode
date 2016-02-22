package array;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || newInterval == null) {
            return intervals;
        }
        List<Interval> rst = new ArrayList<Interval>();
        int pos = 0;
        for (Interval i : intervals) {
            if (i.end < newInterval.start) {
                rst.add(i);
                pos++;
            } else if (newInterval.end < i.start) {
                rst.add(i);
            } else {
                newInterval.start = Math.min(newInterval.start, i.start);
                newInterval.end = Math.max(newInterval.end, i.end);
            }
        }
        rst.add(pos, newInterval);
        return rst;
    }
    public static void main(String[] args) {
    	InsertInterval sol = new InsertInterval();
    	ArrayList<Interval> intervals = new ArrayList<Interval>();
    	intervals.add(new Interval(1, 5));
    	sol.insert(intervals, new Interval(2, 3));
    }
}
class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}