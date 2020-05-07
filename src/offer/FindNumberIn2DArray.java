package offer;

/**
 * @author alery
 * @Description
 * @create 2020-05-07 21:54
 */
public class FindNumberIn2DArray {
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1) return false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0;
        int col = cols - 1;
        while (row < rows && col >= 0) {
            int temp = matrix[row][col];
            if (temp == target) {
                return true;
            } else if (temp > target) {
                col = col - 1;
            } else {
                row = row + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(findNumberIn2DArray(matrix,9));
    }
}
