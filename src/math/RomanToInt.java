package math;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

    public static int romanToInt(String s) {

        Map<String, Integer> map = new HashMap<>();
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("I", 1);
        map2.put("V", 5);
        map2.put("X", 10);
        map2.put("L", 50);
        map2.put("C", 100);
        map2.put("D", 500);
        map2.put("M", 1000);
        int result = 0;
        StringBuffer stringBuffer = new StringBuffer(s);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            int pos = stringBuffer.indexOf(key);
//            System.out.println(key + ":" + pos);
            if (pos != -1) {
                result += value;
                stringBuffer = stringBuffer.deleteCharAt(pos);
                stringBuffer = stringBuffer.deleteCharAt(pos);
            }
        }

        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            while (stringBuffer.indexOf(key) != -1) {
                result += value;
                stringBuffer = stringBuffer.deleteCharAt(stringBuffer.indexOf(key));
            }
        }


        return result;
    }

    public static void main(String[] args) {

        System.out.println(romanToInt("LVIII"));

    }


}
