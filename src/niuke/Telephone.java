package niuke;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author 丶Alery
 * @Description
 * @create 2020-03-22 20:50
 */
public class Telephone {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(",");
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
        for (String string : strings) {
//            System.out.println(string);
//            System.out.println(judge(string));
            int value = judge(string);
            if (map.containsKey(value)) {
                map.get(value).add(string);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(string);
                map.put(value, list);
            }
        }
        for (int i = 22; i >= 5; i--) {
            if (map.containsKey(i)) {
                for (Object o : map.get(i).toArray()) {
                    System.out.print(o);
                }
            }
        }
    }

    public static int judge(String s) {
        char[] chars = s.toCharArray();
        int aaa = 1;
        int abc = 1;
        int max_aaa = 0;
        int max_abc = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] - chars[i - 1] == 1) {
                // 顺子
                abc++;
                max_abc = Math.max(abc, max_abc);
            } else if (chars[i] - chars[i - 1] == 0) {
                // 豹子
                aaa++;
                max_aaa = Math.max(aaa, max_aaa);
            } else {
                // 非豹子顺子，清零重新计算
                aaa = abc = 1;
            }
        }
//        System.out.println(max_aaa);
//        System.out.println(max_abc);
        max_aaa *= 2;
        max_abc = max_abc * 2 - 1;
        return Math.max(max_aaa, max_abc);
    }
}
