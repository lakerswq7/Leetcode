package array;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> rst = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) {
            rst.add(newInterval);
            return rst;
        }
        ArrayList<Integer> inter = new ArrayList<Integer>();
        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();
        for (Interval e : intervals) {
            left.add(e.start);
            right.add(e.end);
        }
        addElement(left, newInterval.start);
        addElement(right, newInterval.end);
        
        int l = 0, r = 0;
        while (l < left.size() || r < right.size()) {
            if (l < left.size() && left.get(l) <= right.get(r)) {
                inter.add(left.get(l));
                l++;
            } else {
                if (inter.size() == 1) {
                    rst.add(new Interval(inter.get(0), right.get(r)));
                }
                inter.remove(inter.size() - 1);
                r++;
            }
        }
        return rst;
    }
    public void addElement(ArrayList<Integer> list, int e) {
        for (int i = 0; i < list.size(); i++) {
            if (e < list.get(i)) {
                list.add(i, e);
                return;
            }
        }
        list.add(e);
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