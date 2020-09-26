package bishi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/12 18:56
 * @Version 1.0
 */

public class Yuanfudao1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] array = new int[n];
        int[] array2 = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int x = 0;
            int y = n / 2;
            int cnt = 0;
            for (int j = 0; j < n / 2; j++) {
                if (i % 2 == 0) {
                    array2[cnt++] = array[y++];
                    array2[cnt++] = array[x++];
                } else {
                    array[cnt++] = array2[y++];
                    array[cnt++] = array2[x++];
                }
            }
            if (cnt < n) {
                if (i % 2 == 0) {
                    array2[n - 1] = array[y];
                } else {
                    array[n - 1] = array2[y];
                }
            }
        }
        if (m % 2 == 0) {
            for (int i = 0; i < array.length - 1; i++) {
                System.out.print(array[i] + " ");
            }
            if (array.length > 1) {
                System.out.println(array[array.length - 1]);
            }
        } else {
            for (int i = 0; i < array2.length - 1; i++) {
                System.out.print(array2[i] + " ");
            }
            if (array2.length > 1) {
                System.out.println(array2[array2.length - 1]);
            }
        }


    }
}
