package bishi;

import java.util.Scanner;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/29 19:19
 * @Version 1.0
 */
// 01010

public class Alibaba1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();

        if (n < 1 || s == null || s.trim().equals("")) {
            System.out.println("0");
            return;
        }

        long sum = 1;
        int cnt = 0;
        int flag = 0;

        if (!s.contains("0")) {
            System.out.println("0");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0' && flag == 0) {
                flag = 1;
                continue;
            }
            if (flag == 1) {
                if (s.charAt(i) == '1') {
                    cnt++;
                } else if (s.charAt(i) == '0') {
                    sum = (sum * (cnt + 1)) % (1000000007);
                    cnt = 0;
                }
            }
        }
//        sum = (sum * (cnt + 1)) % (1000000007);
        System.out.println(sum);
    }
}
