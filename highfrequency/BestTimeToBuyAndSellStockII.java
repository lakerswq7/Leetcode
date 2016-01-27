package highfrequency;

public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        if ((prices == null) || (prices.length < 2)) {
            return 0;
        }
        int profile = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int diff = prices[i + 1] - prices[i];
            if (diff > 0) {
                profile += diff;
            }
        }
        return profile;
    }
//    public int maxProfit(int[] prices) {
//        if ((prices == null) || (prices.length < 2)) {
//            return 0;
//        }
//        int profile = 0;
//        int low = 0;
//        
//        low = prices[0];
//        for (int i = 1; i < prices.length - 1; i++) {
//            if ((prices[i] < prices[i - 1]) && (prices[i] <= prices[i + 1])) {
//                low = prices[i];
//            }
//            if ((prices[i] >= prices[i - 1]) && (prices[i] > prices[i + 1])) {
//                profile += prices[i] - low;
//            }
//        }
//        if (prices[prices.length - 1] >= prices[prices.length - 2]) {
//            profile += prices[prices.length - 1] - low;
//        }
//        return profile;
//    }
}
