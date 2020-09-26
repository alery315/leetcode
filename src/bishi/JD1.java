package bishi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/17 19:33
 * @Version 1.0
 */

public class JD1 {

    final static Pattern pattern = java.util.regex.Pattern.compile("[0-9]{4,}");

    public static List<String> extractAllYear(String s) {
        Matcher matcher = pattern.matcher(s);
        List<String> list = new ArrayList<>();
        while (matcher.find()) {
            String number = matcher.group();
            int i = 0;
            while (number.charAt(i) == '0') {
                i++;
            }
            number = number.substring(i);
            if (number.length() > 4) {
                continue;
            }
            int num = Integer.valueOf(number);
            if (num >= 1000 && num <= 3999) {
                list.add(number);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
//        String s = "201003abc2020";
//        String regEx = "\\d{4}";
//        Pattern pattern = Pattern.compile(regEx);
//        Matcher matcher = pattern.matcher(s);
//        while (true) {
//            if (matcher.find()) {
//                System.out.print(matcher.group() + " ");
//            } else {
//                break;
//            }
//        }
        List<String> list = extractAllYear(s);
        for (int i = 0; i < list.size() - 1; i++) {
            System.out.print(list.get(i).toString() + " ");
        }
        if (list.size() >= 1) {
            System.out.println(list.get(list.size() - 1));
        }

    }

}
