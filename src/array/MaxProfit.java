package array;

public class MaxProfit {




    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5};
        System.out.println(maxProfit(nums));
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        System.out.println(prices.length);
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                System.out.println(prices[i] + "" + prices[i + 1]);
                profit += prices[i + 1] - prices[i];
            }

        }
        return profit;
    }

}
