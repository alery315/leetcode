package leetcode;

/**
 * @author 丶Alery
 * @Description
 * @create 2020-03-23 17:02
 */
public class MaxProfit {

    public static int maxProfit(int[] prices) {

        int min_value = Integer.MAX_VALUE;
        int max_profit = 0;
        int len = prices.length;
        for (int i = 0; i < len; i++) {
            min_value = Math.min(prices[i], min_value);
            max_profit = Math.max(prices[i] - min_value, max_profit);
        }
        return max_profit;
    }

}
