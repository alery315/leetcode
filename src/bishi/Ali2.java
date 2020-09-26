package bishi;

import java.util.Scanner;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/15 19:06
 * @Version 1.0
 */
/*
9 5
110001001
 */
public class Ali2 {

    public static int minSum(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        for (int j = 1; j <= len2; j++) {
            dp[0][j] = dp[0][j - 1] + 1;
        }
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1,
                            dp[i][j - 1] + 1);
                }
            }
        }
        int res1 = 0;
        int res2 = 0;
        for (int i = 0; i <= len1; i++) {
            res1 += dp[i][0];
        }
        for (int i = 0; i <= len2; i++) {
            res2 += dp[0][i];
        }
        return Math.max(res1 + 1, res2 + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println(minSum(s1, s2));

    }

}
