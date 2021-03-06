package dp.sequence;
/**
 * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.

Note:
All costs are positive integers.
 */
public class PaintHouse {
    public int minCost(int[][] costs) {
        int red = 0, green = 0, blue = 0;
        for (int i = 0; i < costs.length; i++) {
            int temp1 = red, temp2 = green;
            red = Math.min(green, blue) + costs[i][0];
            green = Math.min(temp1, blue) + costs[i][1];
            blue = Math.min(temp1, temp2) + costs[i][2];
        }
        return Math.min(red, Math.min(green, blue));
    }
}
