package highfrequency;

public class BestTimeToBuyAndSellStockWithCoolDown {
    public int maxProfit(int[] prices) {
    	/*
    	 * 三个值均表示以这个动作为当前天的动作时，最大的盈利
    	 * buy: 这一天买的状态
    	 * cooldown:这一天什么也没做
    	 * sell:这一天卖
    	 * buy = 之前已经买过了或者之前是cooldown并在这一天买
    	 * cooldown = 之前一天卖了或者之前一天就是cooldown
    	 * sell = 之前有买的状态
    	 */
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int buy = -prices[0];
        int cooldown = 0;
        int sell = 0;
        for (int i = 1; i < prices.length; i++) {
            int b = buy;
            buy = Math.max(buy, cooldown - prices[i]);
            cooldown = Math.max(sell, cooldown);
            sell = b + prices[i];
        }
        return Math.max(cooldown, sell);
    }
}
