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
            	/*
            	 *  这里的算法是，算前j个天，有i次交易机会的时候，是等于
            	 *  A. 前j - 1个天，i次交易机会，意思是，最后一个天不交易
            	 *  or
            	 *  B. 第j天交易，i次交易机会，找最大， 算法是遍历所有1 到 j - 1 天，把每一天当做最后一次
            	 *  交易的买点，把最后一天当做卖点，用得到的值加上, 前1 到 j - 1天，交易i - 1次得到的收益
            	 *  这里temp的意思是， 计算每一天前面i - 1次收益再减去这一天买入的值，取最大, B的值是用这个再加上第j天的价格
            	 */
            	 
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
