package qiuzhao_learn;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/8/30 15:35
 * @Version 1.0
 */

public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        if (m < 1) return res;
        int n = matrix[0].length;
        int sum = m * n;
        int cnt = 0;
        int i = 0, j = 0;
        int min_p = 0;
        while (cnt < sum) {
            while (j < n && cnt < sum) {
                res.add(matrix[i][j]);
                cnt++;
                j++;
            }
            j--;
            i++;
            while (i < m && cnt < sum) {
                res.add(matrix[i][j]);
                cnt++;
                i++;
            }
            i--;
            j--;
            while (j >= min_p && cnt < sum) {
                res.add(matrix[i][j]);
                cnt++;
                j--;
            }
            j++;
            i--;
            while (i > min_p && cnt < sum) {
                res.add(matrix[i][j]);
                cnt++;
                i--;
            }
            m--;
            n--;
            min_p++;
            j++;
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        new SpiralOrder().spiralOrder(new int[][]{
                {1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}
        );
    }


}
