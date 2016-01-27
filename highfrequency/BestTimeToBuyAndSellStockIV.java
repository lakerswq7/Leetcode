package highfrequency;

public class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (k > n / 2) {
            int profit = 0;
            for (int i = 1; i < n; i++) {
                profit += Math.max(prices[i] - prices[i - 1], 0);
            }
            return profit;
        } else {
            int[][] profits = new int[k + 1][n];
            int temp = 0;
            for (int i = 1; i <= k; i++) {
                temp = profits[i - 1][0] - prices[0];
                for (int j = 1; j < n; j++) {
                    profits[i][j] = Math.max(profits[i][j - 1], temp + prices[j]);
                    temp = Math.max(temp, profits[i - 1][j] - prices[j]);
                }
            }
            return profits[k][n - 1];
        }
    }
}
