package bishi;

import java.util.Scanner;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/16 19:27
 * @Version 1.0
 */

public class Jinshanyun1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] fibo = new int[n + 1];
        if (n > 2) {
            fibo[0] = 1;
            fibo[1] = 2;
            for (int i = 2; i < n; i++) {
                fibo[i] = fibo[i - 1] + fibo[i - 2];
            }
        }
        for (int i = 1; i < n + 1; i++) {
            if (i == 1) {
                System.out.println(1);
                continue;
            }
            int sum = 2 * i - 1;
            System.out.print(1+" ");
            sum--;
            int cnt = 0;
            while (sum > 1 && cnt < i-2) {
                System.out.print(fibo[cnt++] + " ");
                sum--;
            }
            while (sum > 1 && cnt >= 0) {
                System.out.print(fibo[cnt--] + " ");
                sum--;
            }
            if (sum == 1) {
                System.out.println(1);
            } else {
                System.out.println();
            }
        }

    }

}
