package highfrequency;

public class BestTimeToBuyAndSellStockWithCoolDown {
    public int maxProfit(int[] prices) {
    	/*
    	 * ����ֵ����ʾ���������Ϊ��ǰ��Ķ���ʱ������ӯ��
    	 * buy: ��һ�����״̬
    	 * cooldown:��һ��ʲôҲû��
    	 * sell:��һ����
    	 * buy = ֮ǰ�Ѿ�����˻���֮ǰ��cooldown������һ����
    	 * cooldown = ֮ǰһ�����˻���֮ǰһ�����cooldown
    	 * sell = ֮ǰ�����״̬
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
