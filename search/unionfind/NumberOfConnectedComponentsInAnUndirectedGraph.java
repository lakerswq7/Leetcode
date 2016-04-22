package search.unionfind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.

Example 1:
     0          3
     |          |
     1 --- 2    4
Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

Example 2:
     0           4
     |           |
     1 --- 2 --- 3
Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

Note:
You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 */
public class NumberOfConnectedComponentsInAnUndirectedGraph {
/*
 * 这题可用DFS， BFS和Union Find做
 */
	//Union Find
    public int countComponents(int n, int[][] edges) {
        int[] father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
        for (int[] e : edges) {
            int father1 = findFather(father, e[0]);
            int father2 = findFather(father, e[1]);
            father[father1] = father2;
        }
        int[] counts = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            int f = findFather(father, i);
            if (counts[f] == 0) {
                count++;
            }
            counts[f]++;
        }
        return count;
    }
    private int findFather(int[] father, int e) {
        if (father[e] == e) {
            return e;
        }
        int f = findFather(father, father[e]);
        father[e] = f;
        return f;
    }
    
	//BFS
    public int countComponents1(int n, int[][] edges) {
        HashSet<Integer> unvisited = new HashSet<Integer>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            unvisited.add(i);
            map.put(i, new ArrayList<Integer>());
        }
        for (int[] e : edges) {
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        int count = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            if (unvisited.contains(i)) {
                queue.offer(i);
                unvisited.remove(i);
                while (!queue.isEmpty()) {
                    int cur = queue.poll();
                    for (int next : map.get(cur)) {
                        if (unvisited.contains(next)) {
                            queue.offer(next);
                            unvisited.remove(next);
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }
    
	//DFS
    int count = 0;
    public int countComponents2(int n, int[][] edges) {
        HashSet<Integer> unvisited = new HashSet<Integer>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            unvisited.add(i);
            map.put(i, new ArrayList<Integer>());
        }
        for (int[] e : edges) {
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        for (int i = 0; i < n; i++) {
            if (unvisited.contains(i)) {
                unvisited.remove(i);
                dfs(map, unvisited, i);
                count++;
            }
        }
        return count;
    }
    private void dfs(HashMap<Integer, ArrayList<Integer>> map, HashSet<Integer> unvisited, int start) {
        for (int next : map.get(start)) {
            if (unvisited.contains(next)) {
                unvisited.remove(next);
                dfs(map, unvisited, next);
            }
        }
    }
}
