package search.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] input = new int[numCourses];
        HashMap<Integer, ArrayList<Integer>> pre = new HashMap<Integer, ArrayList<Integer>>();
        int count = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < prerequisites.length; i++) {
            input[prerequisites[i][0]]++;
            if (!pre.containsKey(prerequisites[i][1])) {
                pre.put(prerequisites[i][1], new ArrayList<Integer>());
            }
            pre.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (input[i] == 0) {
                queue.offer(i);
                count++;
            }
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            if (pre.containsKey(course)) {
                for (int c : pre.get(course)) {
                    input[c]--;
                    if (input[c] == 0) {
                        queue.offer(c);
                        count++;
                    }
                }
            }
        }
        return count == numCourses;
    }
}
