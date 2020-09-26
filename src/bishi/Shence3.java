package bishi;

import java.util.Scanner;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/15 20:31
 * @Version 1.0
 */
/*
5
1 2 3 4 5
2
10
 */

public class Shence3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int num = sc.nextInt();
        int cnt = 0;
        int i = k;
        int op = 1;
        while (cnt < num) {
            System.out.println(arr[i]);
            cnt++;
            i += op;
            if (i == n) {
                i = n - 2;
                op = -op;
            } else if (i == -1) {
                i = 1;
                op = -op;
            }
        }

    }

}
