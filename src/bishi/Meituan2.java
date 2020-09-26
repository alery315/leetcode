package bishi;

import java.util.Scanner;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/13 10:27
 * @Version 1.0
 */
/*
8 2 5
5 5 5 4 4 5 4 5
 */
public class Meituan2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        if (n < 1 || m > n) {
            System.out.println(0);
            return;
        }
        int[] arr = new int[n];
        int index = -1;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] >= k && index == -1) {
                index = i;
            }
        }

        int res = 0;
        for (int i = index; i < n; ) {
            int j = i + 1;
            for (; j < n; j++) {
                if (arr[j] < k) {
                    break;
                }
            }
            if (j - i + 1 >= m) {
                res += j - i + 1 - m;
            }
            while (j < n && arr[j] < k) {
                j++;
            }
            i = j;

        }
        System.out.println(res);
    }
}
