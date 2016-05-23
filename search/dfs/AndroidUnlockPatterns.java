package search.dfs;

import java.util.ArrayList;

/**
 * Given an Android 3x3 key lock screen and two integers m and n, where 1 ¡Ü m ¡Ü n ¡Ü 9, count the total number of unlock patterns of the Android lock screen, which consist of minimum of m keys and maximum n keys.

Rules for a valid pattern:
Each pattern must connect at least m keys and at most n keys.
All the keys must be distinct.
If the line connecting two consecutive keys in the pattern passes through any other keys, the other keys must have previously selected in the pattern. No jumps through non selected key is allowed.
The order of keys used matters.

Explanation:
| 1 | 2 | 3 |
| 4 | 5 | 6 |
| 7 | 8 | 9 |
Invalid move: 4 - 1 - 3 - 6 
Line 1 - 3 passes through key 2 which had not been selected in the pattern.

Invalid move: 4 - 1 - 9 - 2
Line 1 - 9 passes through key 5 which had not been selected in the pattern.

Valid move: 2 - 4 - 1 - 3 - 6
Line 1 - 3 is valid because it passes through key 2, which had been selected in the pattern

Valid move: 6 - 5 - 4 - 1 - 9 - 2
Line 1 - 9 is valid because it passes through key 5, which had been selected in the pattern.

Example:
Given m = 1, n = 1, return 9.
 */
public class AndroidUnlockPatterns {
    public int numberOfPatterns(int m, int n) {
        if (m < 1 || n > 9 || m > n) {
            return 0;
        }
        boolean[] visited = new boolean[10];
        return dfs(new ArrayList<Integer>(), visited, m, n);
   }
   private int dfs(ArrayList<Integer> list, boolean[] visited, int m, int n) {
       if (list.size() == n) {
           return 1;
       }
       int count = 0;
       if (list.size() >= m) {
           count = 1;
       }
       for (int i = 1; i <= 9; i++) {
           if (visited[i]) {
               continue;
           }
           if (list.size() == 0 || isValid(visited, i, list.get(list.size() - 1))) {
               visited[i] = true;
               list.add(i);
               count += dfs(list, visited, m, n);
               list.remove(list.size() - 1);
               visited[i] = false;
           }
       }
       return count;
   }
   private boolean isValid(boolean[] visited, int a, int b) {
       int ax = (a - 1) / 3, ay = (a - 1) % 3;
       int bx = (b - 1) / 3, by = (b - 1) % 3;
       if (Math.max(Math.abs(ax - bx), Math.abs(ay - by)) == 1) {
           return true;
       }
       if (Math.abs(a - b) % 2 == 0) {
           return visited[(a + b) / 2];
       }
       return true;
   }
}
