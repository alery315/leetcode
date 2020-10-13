package bishi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/30 19:02
 * @Version 1.0
 */

public class Hua1 {

    public static int[][] spiralOrder(int[] matrix, int m, int n) {
        int[][] res = new int[m][n];
        if (m < 1) return res;
        int sum = m * n;
        int cnt = 0;
        int i = 0, j = 0;
        int min_p = 0;
        while (cnt < sum) {
            while (j < n && cnt < sum) {
                res[i][j] = matrix[cnt++];
                j++;
            }
            j--;
            i++;
            while (i < m && cnt < sum) {
                res[i][j] = matrix[cnt++];
                i++;
            }
            i--;
            j--;
            while (j >= min_p && cnt < sum) {
                res[i][j] = matrix[cnt++];
                j--;
            }
            j++;
            i--;
            while (i > min_p && cnt < sum) {
                res[i][j] = matrix[cnt++];
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
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
//        int[][] arr = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                arr[i][j] = sc.nextInt();
//            }
//        }
        int[] arr = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[n * i + j] = sc.nextInt();
            }
        }
        Arrays.sort(arr);
        int[][] res = spiralOrder(arr, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }


    }


}
