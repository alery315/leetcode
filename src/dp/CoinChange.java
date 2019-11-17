package dp;


public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] table = new int[amount + 1];
        for (int i = 0; i < amount + 1; i++) table[i] = -2;
        return dp(coins, amount, table);
    }

    public int dp(int[] coins, int amount, int[] table) {
        if (amount == 0) return 0; // 金额为0,返回0
        if (table[amount] != -2) return table[amount]; // 记录过,直接返回结果
        int ans = Integer.MAX_VALUE; // 初始化一个结果为整型最大值
        for (int i = 0; i < coins.length; i++) {
            if (amount < coins[i]) continue; // 金额不够了,进入下一循环
            int sub_res = dp(coins, amount - coins[i], table); // 寻找子问题答案,金额减去当前金币
            if (sub_res == -1) continue; // 子问题无解
            ans = Math.min(ans, sub_res + 1); // 更新ans,寻找一个最小值
        }
        table[amount] = (ans == Integer.MAX_VALUE) ? -1 : ans; // 根据ans的值来更新记录表,是无解还是有解
        return table[amount]; // 返回当前amount的最优解
    }

    public int coinChange2(int[] coins, int amount) {
        int[] dp_table = new int[amount + 1];
        for (int i = 0; i < amount + 1; i++) {
            dp_table[i] = amount + 1;
        }
        dp_table[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp_table[i] = Math.min(dp_table[i], dp_table[i - coin] + 1);
                }
                // 自己写的什么狗屁
//                if (i + coin > amount) continue;
//                ans = Math.min(ans, dp_table[i + coin] + 1);
            }
        }
        return dp_table[amount] > amount ? -1 : dp_table[amount];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5};
        int result = new CoinChange().coinChange2(nums, 11);

        System.out.println(result);


    }

}
