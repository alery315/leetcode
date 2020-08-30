package qiuzhao_learn;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/8/14 19:38
 * @Version 1.0
 */

public class MaxProfit {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int max_profit = 0;
        int min_price = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            if (prices[i] < min_price) {
                min_price = prices[i];
            } else if (prices[i] - min_price > max_profit) {
                max_profit = prices[i] - min_price;
            }
        }
        return max_profit;
    }

    public static void main(String[] args) {

        System.out.println(new MaxProfit().maxProfit(new int[]{3,2,6,5,0,3}));

    }

}
