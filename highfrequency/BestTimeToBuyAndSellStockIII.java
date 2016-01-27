package highfrequency;

public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        if ((prices == null) || (prices.length == 0)) {
            return 0;
        }
        int[] sell = new int[prices.length];
        int[] buy = new int[prices.length];
        int low = prices[0];
        int high = prices[prices.length - 1];
        int profile = 0;
        for (int i = 1; i < prices.length; i++) {
            low = prices[i] < low ? prices[i] : low;
            sell[i] = sell[i - 1] > (prices[i] - low) ? sell[i - 1] : (prices[i] - low);
        }
        for (int i = prices.length - 2; i >= 0; i--) {
            high = prices[i] > high ? prices[i] : high;
            buy[i] = buy[i + 1] > (high - prices[i]) ? buy[i + 1] : (high - prices[i]);
        }
        for (int i = 0; i < prices.length; i++) {
            profile = (sell[i] + buy[i]) > profile ? (sell[i] + buy[i]) : profile;
        }
        return profile;
    }
}
