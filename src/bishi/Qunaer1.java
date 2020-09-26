package bishi;

import java.util.Scanner;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/23 20:09
 * @Version 1.0
 */

public class Qunaer1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[n + 1][n + 1];
        sc.nextLine();
        String s1 = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        String s2 = sc.nextLine();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != ' ') {
                sb.append(s1.charAt(i));
            }
        }
        s1 = sb.toString();
        sb = new StringBuilder();
        for (int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i) != ' ') {
                sb.append(s2.charAt(i));
            }
        }
        s2 = sb.toString();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(j);
                if (c1 == c2) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        System.out.println(dp[n][n]);




    }



}
