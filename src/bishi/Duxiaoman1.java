package bishi;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/20 20:37
 * @Version 1.0
 */

public class Duxiaoman1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            if (map.containsKey(c)) {
                int temp = map.get(c);
                if (temp >= 1) {
                    map.put(c, temp - 1);
                    res++;
                }
            }
        }
        System.out.println(res);
    }

}
