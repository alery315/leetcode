package bishi;

import java.util.Scanner;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/8 18:38
 * @Version 1.0
 *
123 12345678 123abcABC!!!
 */

public class Xiaomi1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strings = s.split(" ");
        for (String string : strings) {
            int[] cnts = new int[4];
            if (string.length() < 8 || string.length() > 120) {
                System.out.println("1");
                continue;
            }
            for (int i = 0; i < string.length(); i++) {
                char c = string.charAt(i);
                if (c >= '0' && c <= '9') {
                    cnts[0] = 1;
                } else if (c >= 'a' && c <= 'z') {
                    cnts[1] = 1;
                } else if (c >= 'A' && c <= 'Z') {
                    cnts[2] = 1;
                } else {
                    cnts[3] = 1;
                }

            }
            int cnt = 0;
            for (int i = 0; i < 4; i++) {
                cnt += cnts[i];
            }
            if (cnt == 4) {
                System.out.println("0");
            } else {
                System.out.println("2");
            }

        }

    }

}
