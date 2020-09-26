package bishi;

import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;


/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/12 18:56
 * @Version 1.0
 */

public class Yuanfudao3 {
    static boolean isInte(String str) {
        Pattern pattern= Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < t; i++) {
            String s = sc.nextLine();
            System.out.println(s);
            Stack<String> stack = new Stack<>();
            for (int j = s.length() - 1; j >= 0; j--) {
                if (s.charAt(j) == ')') {
                    stack.push(String.valueOf(s.charAt(j)));
                } else if (s.charAt(j) == '+' || s.charAt(j) == '-' || s.charAt(j) == '*') {
                    if (stack.size() < 2) {
                        System.out.println("invalid");
                        break;
                    }
                    String c1 = stack.pop();
                    String c2 = stack.pop();
                    int num1 = 0;
                    int num2 = 0;
                    int num3 = 0;
                    if (isInte(c1)) {
                        num1 = Integer.parseInt(c1);
                    } else {
                        System.out.println("invalid");
                        break;
                    }
                    if (isInte(c2)) {
                        num2 = Integer.parseInt(c2);
                    } else {
                        System.out.println("invalid");
                        break;
                    }
                    String c3 = stack.pop();
                    if (c3.equals(")")) {
                        System.out.println("invalid");
                        break;
                    }
                    while (s.charAt(j) != '(') {
                        j++;
                    }
                    if (s.charAt(j) == '+') {
                        num3 = num1 + num2;
                    } else if (s.charAt(j) == '-') {
                        num3 = num1 - num2;
                    } else {
                        num3 = num1 * num2;
                    }
                    stack.push(String.valueOf(num3));

                } else if (s.charAt(j) == ' ') {
                    continue;
                }
            }




        }


    }
}
