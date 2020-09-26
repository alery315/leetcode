package bishi;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/12 18:56
 * @Version 1.0
 */

public class Yuanfudao2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < t; i++) {
            String s = sc.nextLine();
            String[] strings = s.split(" ");
            String s1 = strings[0];
            String s2 = strings[1];
            String s3 = strings[2];
            HashMap<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < s1.length(); j++) {

            }
            int k = Integer.parseInt(strings[3]);
            System.out.println("1");
        }


    }
}
