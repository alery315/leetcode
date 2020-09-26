package bishi;

import javax.swing.*;
import java.util.Scanner;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/8/30 22:01
 * @Version 1.0
 */

public class Xiaomi22 {
    public static boolean exist(char[][] board, String word) {
        if(word == null || word.length() < 1)return false;
        boolean[][] visit = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j] && dfs(board, i, j, 0, word, visit)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, int i, int j, int p, String word, boolean[][] visit) {
        if (p == word.length()) {
            return true;
        }
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word.charAt(p) || visit[i][j]) {
            return false;
        }
        visit[i][j] = true;
        if (dfs(board, i + 1, j, p + 1, word, visit) || dfs(board, i - 1, j, p + 1, word, visit) || dfs(board, i, j + 1, p + 1, word, visit) ||
                dfs(board, i, j - 1, p + 1, word, visit)) {
            return true;
        }
        visit[i][j] = false;
        return false;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist(board, s));
    }
}
