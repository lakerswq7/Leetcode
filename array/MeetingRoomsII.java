package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.
 */
public class MeetingRoomsII {
    public int minMeetingRooms(Interval[] intervals) {
        ArrayList<Integer> time = new ArrayList<Integer>();
        for (Interval i : intervals) {
            time.add(i.start);
            time.add(-i.end);
        }
        Collections.sort(time, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                if (a == -b) {
                    return a;
                }
                return Math.abs(a) - Math.abs(b);
            }
        });
        int count = 0;
        int max = 0;
        for (int t : time) {
            if (t >= 0) {
                count++;
                max = Math.max(count, max);
            } else {
                count--;
            }
        }
        return max;
    }
}
