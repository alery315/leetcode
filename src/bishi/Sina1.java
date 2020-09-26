package bishi;

import java.util.*;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/13 16:14
 * @Version 1.0
 */

public class Sina1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] == chars[i]) {
                System.out.println("false");
                return;
            }
        }
        System.out.println("true");
    }
}
