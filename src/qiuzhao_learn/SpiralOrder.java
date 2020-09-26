package qiuzhao_learn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        // [[1, 2, 3],[4 ,5 ,6],[7, 8,9]]
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String new_s = s.replace("[", "");
        int m = s.length() - new_s.length() - 1;
        if (m == 0) {
            System.out.println("[]");
            System.exit(0);
        }
        new_s = new_s.replace(" ", "");
        new_s = new_s.replace("]", "");
        int n = (new_s.length() + 1) / 2 / m;
        int[][] nums = new int[m][n];
        String[] strings = new_s.split(",");
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = Integer.parseInt(strings[cnt++]);
            }
        }
        List<Integer> list = new SpiralOrder().spiralOrder(nums);
        System.out.print("[");
        for (int i = 0; i < list.size()-1; i++) {
            System.out.print(list.get(i) + ",");
        }
        if (list.size() > 1) {
            System.out.print(list.get(list.size() - 1));
        }
        System.out.print("]");
    }
}
