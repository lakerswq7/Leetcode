package search.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] input = new int[numCourses];
        int[] order = new int[numCourses];
        int index = 0;
        HashMap<Integer, ArrayList<Integer>> pre = new HashMap<Integer, ArrayList<Integer>>();
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
            }
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            order[index++] = course;
            if (pre.containsKey(course)) {
                for (int c : pre.get(course)) {
                    input[c]--;
                    if (input[c] == 0) {
                        queue.offer(c);
                    }
                }
            }
        }
        return index == numCourses ? order : new int[0];
    }
}
