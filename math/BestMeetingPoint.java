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
 * ��������ô�ͳ��BFS���⣬�������������
 * ���ֽⷨ��
 * 1. sort: ʵ��������ֻ��Ҫ��ÿһ��ά�����ҵ���λ��������
 * 2. ��sort ֻ�����ռ� col �� row��ʱ��˳���������ˣ�˼�����һ����һ���ģ�ֻ��������Ҫsort��
 * ��2���������ַ��������㣬һ�����õ���λ�㣬�ֱ��ȥÿһ��������룬������Ϊ��λ��һ�����м䣬ֱ����
 * ÿ������λ�ĵ�֮��ľ���Ϳ�����
 * ������һ���Ҽ�building������building��̾����ǵ�Ҫ��bfs������Ϊ����ȷ���Ƿ��ܴﵽ����building
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
