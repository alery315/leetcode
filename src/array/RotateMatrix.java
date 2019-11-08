package array;

public class RotateMatrix {

    public void rotate(int[][] matrix) {
        int m = matrix.length;
        // 首先转置矩阵
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                if (matrix[i][j] == matrix[j][i]) continue;
                matrix[i][j] = matrix[i][j] ^ matrix[j][i];
                matrix[j][i] = matrix[i][j] ^ matrix[j][i];
                matrix[i][j] = matrix[i][j] ^ matrix[j][i];
            }
        }

        //
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][m - j - 1];
                matrix[i][m - j - 1] = tmp;
            }
        }

    }

    public static void main(String[] args) {

        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        new RotateMatrix().rotate(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }


    }

}
