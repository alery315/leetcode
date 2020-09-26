package bishi;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/17 19:33
 * @Version 1.0
 */

public class JD2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
            char[][] chars = new char[n][m];
            for (int j = 0; j < n; j++) {
                String s = sc.nextLine();
                for (int k = 0; k < m; k++) {
                    chars[i][j] = s.charAt(j);
                }
            }
            System.out.println();
        }
        System.out.println();

    }

}
