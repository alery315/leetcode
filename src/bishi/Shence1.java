package bishi;

import java.util.Scanner;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/15 20:31
 * @Version 1.0
 */

public class Shence1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println((n > 0 && (n & (n - 1)) == 0) ? "True" : "False");
    }

}
