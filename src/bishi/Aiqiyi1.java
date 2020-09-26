package bishi;

import java.util.Scanner;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/13 15:13
 * @Version 1.0
 */

public class Aiqiyi1 {


    public static int longest(String s) {
        int maxCount = 0;
        int leftIndex = 0;

        for (int i = 0; i < s.length(); i++) {

            for (int inIndex = leftIndex; inIndex < i; inIndex++) {

                if (s.charAt(inIndex) == s.charAt(i)) {
                    maxCount = Math.max(maxCount, i - leftIndex);
                    leftIndex = inIndex + 1;
                    break;
                }
            }
        }
        return Math.max(maxCount, s.length() - leftIndex);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(longest(s));

    }

}
