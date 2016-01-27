package highfrequency;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if ((prices == null) || (prices.length == 0)) {
            return 0;
        }
        int preMin = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            preMin = Math.min(prices[i], preMin);
            profit = Math.max(profit, prices[i] - preMin);
        }
        return profit;
    }
}
