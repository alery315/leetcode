package alibaba;

import java.util.*;

/**
 * 5
 * 5 9 5 4 4
 * 4 7 4 10 3
 * 2 10 9 2 3
 */

public class MinDiffSum2 {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] array = new int[3][n];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = sc.nextInt();
            }
        }
        int[][] dp = new int[3][n];
        for (int i = 0; i < 3; i++) {
            Arrays.fill(dp[i],0);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                dp[j][i] = min(dp[0][i - 1] + Math.abs(array[0][i - 1] - array[j][i])
                        , dp[1][i - 1] + Math.abs(array[1][i - 1] - array[j][i])
                        , dp[2][i - 1] + Math.abs(array[2][i - 1] - array[j][i]));
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(min(dp[0][n - 1], dp[1][n - 1], dp[2][n - 1]));
    }

    public static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
