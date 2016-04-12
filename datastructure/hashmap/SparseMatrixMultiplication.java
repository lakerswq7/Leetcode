package datastructure.hashmap;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Given two sparse matrices A and B, return the result of AB.

You may assume that A's column number is equal to B's row number.

Example:

A = [
  [ 1, 0, 0],
  [-1, 0, 3]
]

B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]


     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |
 */
public class SparseMatrixMultiplication {
	/*
	 * 用hashmap存每一个单独有值的点
	 */
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length, k = A[0].length, n = B[0].length;
        int[][] C = new int[m][n];
        HashMap<Integer, ArrayList<Pair>> mapA = new HashMap<Integer, ArrayList<Pair>>();
        HashMap<Integer, ArrayList<Pair>> mapB = new HashMap<Integer, ArrayList<Pair>>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                if (A[i][j] != 0) {
                    if (!mapA.containsKey(j)) {
                        mapA.put(j, new ArrayList<Pair>());
                    }
                    mapA.get(j).add(new Pair(i, A[i][j]));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                if (B[j][i] != 0) {
                    if (!mapB.containsKey(j)) {
                        mapB.put(j, new ArrayList<Pair>());
                    }
                    mapB.get(j).add(new Pair(i, B[j][i]));
                }
            }
        }
        for (int s : mapA.keySet()) {
            if (mapB.containsKey(s)) {
                for (Pair pA : mapA.get(s)) {
                    for (Pair pB : mapB.get(s)) {
                        C[pA.pos][pB.pos] += pA.val * pB.val;
                    }
                }
            }
        }
        return C;
    }
    class Pair {
        int pos;
        int val;
        Pair(int pos, int val) {
            this.pos = pos;
            this.val = val;
        }
    }
}
