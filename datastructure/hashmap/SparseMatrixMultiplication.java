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
        if (A == null || B == null || A.length == 0 || A[0].length == 0 || A[0].length != B.length || B[0].length == 0) {
            return null;
        }
        HashMap<Integer, ArrayList<Integer>> mapA = new HashMap<Integer, ArrayList<Integer>>();
        HashMap<Integer, ArrayList<Integer>> mapB = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] != 0) {
                    if (!mapA.containsKey(j)) {
                        mapA.put(j, new ArrayList<Integer>());
                    }
                    mapA.get(j).add(i);
                }
            }
        }
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                if (B[i][j] != 0) {
                    if (!mapB.containsKey(i)) {
                        mapB.put(i, new ArrayList<Integer>());
                    }
                    mapB.get(i).add(j);
                }
            }
        }
        int[][] C = new int[A.length][B[0].length];
        for (int k : mapA.keySet()) {
            if (mapB.containsKey(k)) {
                for (int i : mapA.get(k)) {
                    for (int j : mapB.get(k)) {
                        C[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }
        return C;
    }
}
