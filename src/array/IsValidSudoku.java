package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        // 判断行
        for (int i = 0; i < m; i++) {
            if (!judge(board[i])) return false;
        }

        // 判断列
        for (int i = 0; i < n; i++) {
            char[] t = new char[9];
            for (int j = 0; j < m; j++) {
                t[j] = board[j][i];
            }
            if (!judge(t)) return false;
//            System.out.println(Arrays.toString(t));
        }

        // 判断正方形
        for (int i = 0; i < 9; i += 3) {
            for (int z = 0; z < 9; z += 3) {
                char[] t = new char[9];
                int count = 0;
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        t[count++] = board[i + j][z + k];
                    }
                }
                if (!judge(t)) return false;
//                System.out.println(Arrays.toString(t));
            }

        }
        return true;
    }

    public boolean judge(char[] seq) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < seq.length; i++) {
            if (seq[i] != '.') list.add((int) seq[i] - '0');
        }
        Set<Integer> set = new HashSet<>(list);
//        for (Integer integer : list) {
//            System.out.println(integer);
//        }
        return list.size() == set.size();
    }

    public static void main(String[] args) {

        char[][] board = new char[][]
                {{'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(new IsValidSudoku().judge(board[1]));
        System.out.println(new IsValidSudoku().isValidSudoku(board));
    }
}