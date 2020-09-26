package bishi;

import java.util.Scanner;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/15 20:31
 * @Version 1.0
 */
/*
abc def  efg
 */

public class Shence2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strings = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < strings.length; j++) {
            String string = strings[j];
            if (string.trim().length() >= 1) {
                for (int i = string.length() - 1; i >= 0; i--) {
                    sb.append(string.charAt(i));
                }
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }

}
