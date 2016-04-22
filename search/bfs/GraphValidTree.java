package search.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

For example:

Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

Hint:

Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is this case a valid tree?
According to the definition of tree on Wikipedia: ¡°a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.¡±
Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 */
public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        if (n <= 0) {
            return false;
        }
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        int[] visiting = new int[n];
        int count = 0;
        for (int[] e : edges) {
            if (!map.containsKey(e[0])) {
                map.put(e[0], new ArrayList<Integer>());
            }
            map.get(e[0]).add(e[1]);
            if (!map.containsKey(e[1])) {
                map.put(e[1], new ArrayList<Integer>());
            }
            map.get(e[1]).add(e[0]);
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);
        visiting[0] = 1;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            visiting[cur] = 2;
            count++;
            if (map.containsKey(cur)) {
                for (int next : map.get(cur)) {
                    if (visiting[next] == 1) {
                        return false;
                    }
                    if (visiting[next] == 0) {
                        queue.offer(next);
                        visiting[next] = 1;
                    }
                }
            }
        }
        return count == n;
    }
}
