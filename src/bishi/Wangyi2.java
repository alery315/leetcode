package bishi;

import java.util.Scanner;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/12 15:35
 * @Version 1.0
 */

public class Wangyi2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int len = s.length();
        int res = 0;

        for (int i = 0; i < len; i++) {
            int[] abcxyz = new int[6];
            if (s.charAt(i) == 'a' || s.charAt(i) == 'b' || s.charAt(i) == 'c') {
                abcxyz[s.charAt(i) - 'a']++;
            }
            if (s.charAt(i) == 'x' || s.charAt(i) == 'y' || s.charAt(i) == 'z') {
                abcxyz[s.charAt(i) - 'x' + 3]++;
            }
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(j) == 'a' || s.charAt(j) == 'b' || s.charAt(j) == 'c') {
                    abcxyz[s.charAt(j) - 'a']++;
                }
                if (s.charAt(j) == 'x' || s.charAt(j) == 'y' || s.charAt(j) == 'z') {
                    abcxyz[s.charAt(j) - 'x' + 3]++;
                }
                int flag = 1;
                for (int k = 0; k < 6; k++) {
                    if (abcxyz[k] % 2 != 0) {
                        flag = 0;
                        break;
                    }
                }
                if (flag == 1) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        System.out.println(res);

    }
}
