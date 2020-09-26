package bishi;

import java.util.Scanner;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/15 19:06
 * @Version 1.0
 */
/*
9 5
110001001
 */
public class Ali1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        int cnt = 0;
        int find = 1;
        int i = 0;
        for (; i < s.length(); i++) {
            if (s.charAt(i) - '0' == find) {
                continue;
            } else {
                cnt++;
                if (cnt == k) {
                    break;
                }
                if (find == 1) {
                    find = 0;
                } else {
                    find = 1;
                }
            }
        }
//        System.out.println(i);
        if (i >= s.length() - 1) {
            if (k % 2 == 0) {
                System.out.println(s.charAt(s.length() - 1));
            } else {
                if (s.charAt(s.length() - 1) == '1') {
                    System.out.println('0');
                } else {
                    System.out.println('1');
                }
            }
            return;
        }
        if (i < s.length() - 1) {
            if (k % 2 == 0) {
                for (int j = i; j < s.length(); j++) {
                    System.out.print(s.charAt(j));
                }
                System.out.println();
            } else {
                for (int j = i; j < s.length(); j++) {
                    if (s.charAt(j) == '1') {
                        System.out.print('0');
                    } else {
                        System.out.print('1');
                    }
                }
                System.out.println();
            }
        }

    }

}
