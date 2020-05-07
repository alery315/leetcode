package wangyi;

import java.util.*;

/**
 * @author 丶Alery
 * @Description
 * @create 2020-04-07 20:29
 */
public class Main {

    public static int[][] res = new int[1001][1001];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] array = new int[n][m];
        String s;
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            char[] chars;
            s = sc.nextLine();
            chars = s.toCharArray();
            for (int j = 0; j < m; j++) {
                array[i][j] = chars[j] - '0';
                res[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (array[i][j] == 1) {
                    dfs(array, i, j, 0, n, m, i, j);
                } else {
                    res[i][j] = 0;
                }

            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - 1; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println(res[i][m-1]);
        }
    }

    public static void dfs(int[][] arr, int i, int j, int dis, int n, int m, int t_i, int t_j) {
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return;
        }
        if (arr[i][j] == 0) {
            res[t_i][t_j] = Math.min(res[t_i][t_j], dis);
            return;
        }

        if (0 <= i - 1 && i - 1 < n) {
            dfs(arr, i - 1, j, dis + 1, n, m, t_i, t_j);
        }
        if (0 <= i + 1 && i + 1 < n) {
            dfs(arr, i + 1, j, dis + 1, n, m, t_i, t_j);
        }
        if (0 <= j - 1 && j - 1 < n) {
            dfs(arr, i, j - 1, dis + 1, n, m, t_i, t_j);
        }
        if (0 <= j + 1 && j + 1 < n) {
            dfs(arr, i, j + 1, dis + 1, n, m, t_i, t_j);
        }


    }


}
