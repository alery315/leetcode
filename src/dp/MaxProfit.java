package dp;

public class MaxProfit {

    /**
     * 我是个傻逼
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        int max_profit = 0;
        for (int i = 0; i < len; i++) {
            int p_max = -1;
            for (int j = i + 1; j < len; j++) {
                if (prices[j] > p_max) p_max = prices[j];
            }
            if (p_max > prices[i]) {
                if (p_max - prices[i] > max_profit) {
                    max_profit = p_max - prices[i];
                }
            }
        }
        return max_profit;
    }

    /**
     * 寻找最小的点与点之后最大的峰值,即最大的利润,
     * 如果小于最小值,则更新最小值,否则判断它减去最小值是否大于当前最大值
     *
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {

        int len = prices.length;
        if (len == 0) return 0;
        int min, max = 0;
        min = prices[0];
        for (int i = 1; i < len; i++) {
            if (prices[i] <= min) {
                min = prices[i];
            } else if (max < prices[i] - min) {
                max = prices[i] - min;
            }
        }
        return max;
    }

    public static int maxProfit3(int[] prices) {

        int last = 0, profit = 0;
        int len = prices.length;
        for (int i = 0; i < len - 1; i++) {
            int temp = last + prices[i + 1] - prices[i];
            last = max(0, temp);
            profit = max(profit, last);
        }
        return profit;
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{10, 2, 6, 1, 2, 1, 9, 1};

        System.out.println(maxProfit3(nums));

    }

}
