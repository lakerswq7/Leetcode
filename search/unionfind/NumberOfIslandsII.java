package search.unionfind;

import java.util.ArrayList;
import java.util.List;

/**
 * A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns the water at position (row, col) into a land. Given a list of positions to operate, count the number of islands after each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example:

Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).

0 0 0
0 0 0
0 0 0
Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.

1 0 0
0 0 0   Number of islands = 1
0 0 0
Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.

1 1 0
0 0 0   Number of islands = 1
0 0 0
Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.

1 1 0
0 0 1   Number of islands = 2
0 0 0
Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.

1 1 0
0 0 1   Number of islands = 3
0 1 0
We return the result as an array: [1, 1, 2, 3]

Challenge:

Can you do it in time complexity O(k log mn), where k is the length of the positions?
 */
public class NumberOfIslandsII {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> rst = new ArrayList<Integer>();
        int[][] map = new int[m][n];
        int[] father = new int[m * n + 1];
        int[] iX = new int[]{-1, 1, 0, 0};
        int[] iY = new int[]{0, 0, 1, -1};
        int count = 0;
        int group = 1;
        for (int[] p : positions) {
            map[p[0]][p[1]] = group;
            father[group] = group;
            count++;
            for (int k = 0; k < 4; k++) {
                int newX = p[0] + iX[k];
                int newY = p[1] + iY[k];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && map[newX][newY] != 0) {
                    int f = findFather(map[newX][newY], father);
                    if (f != group) {
                        father[f] = group;
                        count--;
                    }
                }
            }
            rst.add(count);
            group++;
        }
        return rst;
    }
    private int findFather(int group, int[] father) {
        if (father[group] == group) {
            return group;
        }
        int f = findFather(father[group], father);
        father[group] = f;
        return f;
    }
}
