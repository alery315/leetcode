package midium_array_string;

import java.util.ArrayList;
import java.util.List;

public class SetZeroes {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return;
        int n = matrix[0].length;
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    lists.add(list);
                }
            }
        }

        for (List<Integer> list : lists) {
            int i = list.get(0);
            int j = list.get(1);
            for (int k = 0; k < n; k++) {
                matrix[i][k] = 0;
            }
            for (int k = 0; k < m; k++) {
                matrix[k][j] = 0;
            }
        }

    }

    public static void main(String[] args) {
        int matrix[][] = {{0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}};
        new SetZeroes().setZeroes(matrix);
        System.out.println("ok");

    }

}
