package bishi;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/10/10 19:30
 * @Version 1.0
 */

public class Jianshe1 {

    public int carsTrans(int[] cars, int num) {
        // write code here
        int[] dp = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            dp[i] = -1;
        }
        dp[0] = 0;
        for (int i = 1; i <= num; i++) {
            for (int j = 0; j < cars.length; j++) {
                if (i - cars[j] >= 0 && dp[i - cars[j]] != -1) {
                    if (dp[i] == -1) {
                        dp[i] = dp[i - cars[j]] + 1;
                    } else {
                        dp[i] = Math.min(dp[i], dp[i - cars[j]] + 1);
                    }
                }
            }
        }
        return dp[num];

    }


}
