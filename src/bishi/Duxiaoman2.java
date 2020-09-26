package bishi;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/20 20:37
 * @Version 1.0
 */
/*
1
5 5
##*##
...##
.#@.*
####.
#####

1
4 4
####
#@**
***#
####
 */

public class Duxiaoman2 {

    static int res = Integer.MAX_VALUE;

    static void dfs(char[][] map, int x, int y, boolean[][] visited, int fun, int n, int m) {
        if (x <= 1 || y <= 1 || x >= n || y >= m) {
            res = Math.min(fun, res);
            return;
        }
        // 上
        if (map[x - 1][y] == '.' && !visited[x - 1][y]) {
            visited[x - 1][y] = true;
            dfs(map, x - 1, y, visited, fun, n, m);
            visited[x - 1][y] = false;
        } else if (map[x - 1][y] == '*' && !visited[x - 1][y]) {
            visited[x - 1][y] = true;
            dfs(map, x - 1, y, visited, fun + 1, n, m);
            visited[x - 1][y] = false;
        }

        // 下
        if (map[x + 1][y] == '.' && !visited[x + 1][y]) {
            visited[x + 1][y] = true;
            dfs(map, x + 1, y, visited, fun, n, m);
            visited[x + 1][y] = false;
        } else if (map[x + 1][y] == '*' && !visited[x + 1][y]) {
            visited[x + 1][y] = true;
            dfs(map, x + 1, y, visited, fun + 1, n, m);
            visited[x + 1][y] = false;
        }

        // 左
        if (map[x][y - 1] == '.' && !visited[x][y - 1]) {
            visited[x][y - 1] = true;
            dfs(map, x, y - 1, visited, fun, n, m);
            visited[x][y - 1] = false;
        } else if (map[x][y - 1] == '*' && !visited[x][y - 1]) {
            visited[x][y - 1] = true;
            dfs(map, x, y - 1, visited, fun + 1, n, m);
            visited[x][y - 1] = false;
        }

        // 右
        if (map[x][y + 1] == '.' && !visited[x][y + 1]) {
            visited[x][y + 1] = true;
            dfs(map, x, y + 1, visited, fun, n, m);
            visited[x][y + 1] = false;
        } else if (map[x][y + 1] == '*' && !visited[x][y + 1]) {
            visited[x][y + 1] = true;
            dfs(map, x, y + 1, visited, fun + 1, n, m);
            visited[x][y + 1] = false;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            res = Integer.MAX_VALUE;
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
            char[][] map = new char[n + 2][m + 2];
            boolean[][] visited = new boolean[n + 2][m + 2];
            int x = 0, y = 0;
            for (int j = 1; j <= n; j++) {
                String s = sc.nextLine();
                for (int k = 1; k <= m; k++) {
                    if (s.charAt(k - 1) == '@') {
                        x = j;
                        y = k;
                    }
                    map[j][k] = s.charAt(k - 1);
                }
            }
//            System.out.println(x + ": " + y);
            visited[x][y] = true;
            dfs(map, x, y, visited, 0, n, m);
            System.out.println(res == Integer.MAX_VALUE ? -1 : res);

        }
    }

}
