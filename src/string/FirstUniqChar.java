package string;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description
 * @auther alery
 * @create 2019-09-17 下午3:36
 */

public class FirstUniqChar {

    public static int firstUniqChar(String s) {

        Map<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), -1);
            } else {
                map.put(s.charAt(i), i);
            }
        }

        for (Integer value : map.values()) {
            if (value != -1) {
                return value;
            }
        }

        return -1;
    }

    public static int firstUniqChar2(String s) {
        int index = s.length();
        for (char i = 'a'; i <= 'z'; i++) {
            int l = s.indexOf(i);
            int r = s.lastIndexOf(i);
//            System.out.println(l + " " + r);
            if (l == r && l != -1) {
                index = Math.min(index, l);
            }
        }
        if (index == s.length()) return -1;
        return index;
    }

    public static void main(String[] args) {


        String s = "loveleetcode";

        System.out.println(firstUniqChar2(s));


    }

}
