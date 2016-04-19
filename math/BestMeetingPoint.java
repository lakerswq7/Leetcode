package math;

import java.util.ArrayList;

/**
 * A group of two or more people wants to meet and minimize the total travel distance. You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

For example, given three people living at (0,0), (0,4), and (2,2):

1 - 0 - 0 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0
The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal. So return 6.

Hint:

Try to solve it in one dimension first. How can this solution apply to the two dimension case?
 */

/*
 * 这题可以用传统的BFS来解，但是那样会很慢
 * 两种解法：
 * 1. sort: 实际上我们只需要在每一个维度上找到中位数就行了
 * 2. 不sort 只是在收集 col 和 row的时候按顺序来就行了，思想根第一种是一样的，只不过不需要sort了
 * 在2里又有两种方法来计算，一种是拿到中位点，分别减去每一个点求距离，或者因为中位点一定在中间，直接算
 * 每两个首位的点之间的距离就可以了
 * 而另外一道找减building离其他building最短距离那道要用bfs，是因为不能确定是否能达到各个building
 */
public class BestMeetingPoint {
    public int minTotalDistance(int[][] grid) {
        ArrayList<Integer> rows = new ArrayList<Integer>();
        ArrayList<Integer> cols = new ArrayList<Integer>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    rows.add(i);
                }
            }
        }
        for (int j = 0; j < grid[0].length; j++) {
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] == 1) {
                    cols.add(j);
                }
            }
        }
        return getDis(rows.get(rows.size() / 2), rows) + getDis(cols.get(cols.size() / 2), cols);
    }
    private int getDis(int value, ArrayList<Integer> list) {
        int distance = 0;
        for (int l : list) {
            distance += Math.abs(l - value);
        }
        return distance;
    }
}
