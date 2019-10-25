package string;

import javax.swing.*;

/**
 * @Description
 * @auther alery
 * @create 2019-09-17 下午4:32
 */

public class IsPalindrome {


    public static boolean isPalindrome(String s) {

        s = s.toLowerCase();
        int len = s.length();
        int i = 0, j = len - 1;
        while (i < j){

            while (isNotAlpha(s.charAt(i)) && i < j) {
                i++;
            }

            while (isNotAlpha(s.charAt(j)) && i < j) {
                j--;
            }

            if (i > j) {
                return true;
            }

            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isNotAlpha(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) return false;
        return true;
    }

    public static void main(String[] args) {

        String s = "0P";
        System.out.println(isPalindrome(s));
    }

}
