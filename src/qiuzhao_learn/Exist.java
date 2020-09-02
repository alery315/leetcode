package qiuzhao_learn;

import sun.nio.cs.FastCharsetProvider;

import java.awt.geom.FlatteningPathIterator;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/8/30 22:01
 * @Version 1.0
 */

public class Exist {
    public boolean exist(char[][] board, String word) {
        if (board.length < 1) return false;
        int m = board.length;
        int n = board[0].length;
        boolean[][] visit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visit[i][j] = false;
            }
        }
        boolean flag = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visit[i][j] = true;
                    flag = dfs(board, word, 1, word.length(), i, j, m, n, visit) || flag;
                    visit[i][j] = false;
                }
            }
        }
        return flag;
    }

    public boolean dfs(char[][] board, String word, int p, int len, int i, int j, int m, int n, boolean[][] visit) {
        if (p == len) {
            return true;
        }
        boolean flag = false;
        // 上
        if (i - 1 < m && i - 1 >= 0 && j < n && j >= 0) {
            if (board[i - 1][j] == word.charAt(p) && !visit[i - 1][j]) {
                visit[i - 1][j] = true;
                flag = dfs(board, word, p + 1, len, i - 1, j, m, n, visit) || flag;
                visit[i - 1][j] = false;
                if (flag) return true;
            }
        }
        // 下
        if (i + 1 < m && i + 1 >= 0 && j < n && j >= 0 && !visit[i + 1][j]) {
            if (board[i + 1][j] == word.charAt(p)) {
                visit[i + 1][j] = true;
                flag = dfs(board, word, p + 1, len, i + 1, j, m, n, visit) || flag;
                visit[i + 1][j] = false;
                if (flag) return true;
            }
        }

        // 左
        if (i < m && i >= 0 && j - 1 < n && j - 1 >= 0 && !visit[i][j - 1]) {
            if (board[i][j - 1] == word.charAt(p)) {
                visit[i][j - 1] = true;
                flag = dfs(board, word, p + 1, len, i, j - 1, m, n, visit) || flag;
                visit[i][j - 1] = false;
                if (flag) return true;
            }
        }

        // 右
        if (i < m && i >= 0 && j + 1 < n && j + 1 >= 0 && !visit[i][j + 1]) {
            if (board[i][j + 1] == word.charAt(p)) {
                visit[i][j + 1] = true;
                flag = dfs(board, word, p + 1, len, i, j + 1, m, n, visit) || flag;
                visit[i][j + 1] = false;
                if (flag) return true;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(new Exist().exist(board, "ABCCED"));
        System.out.println(new Exist().exist(board, "SEE"));
        System.out.println(new Exist().exist(board, "ABCB"));
        System.out.println(new Exist().exist(board, "ABCCEDAS"));

    }
}
