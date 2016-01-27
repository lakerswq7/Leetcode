package datastructure.hashmap;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int n : num) {
            set.add(n);
        }
        int max = 0;
        int consec;
        for (int n : num) {
            if (set.contains(n)) {
                consec = 1;
                int tmp = n + 1;
                while (set.contains(tmp)) {
                    set.remove(tmp);
                    tmp++;
                    consec++;
                }
                tmp = n - 1;
                while (set.contains(tmp)) {
                    set.remove(tmp);
                    tmp--;
                    consec++;
                }
                max = Math.max(max, consec);
            }
        }
        return max;
    }
}
