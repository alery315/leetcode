package qiuzhao_learn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author alery
 * @Description
 * @create 2020-07-29 22:02
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
//                System.out.println(left + ":" + (map.get(s.charAt(i)) + 1 + ":" + s.charAt(i)));
                left = Math.max(map.get(s.charAt(i)) + 1, left);
//                 控制滑动窗口左侧的移动，不能无脑更新，不能更新比当前left还小的值
//                left = map.get(s.charAt(i)) + 1;
                System.out.println(left);
            }
            map.put(s.charAt(i), i);
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }

    public int lengthOfLongestSubstring3(String s) {
        int maxCount = 0;
        int leftIndex = 0;
        char[] ss = s.toCharArray();

        for (int i = 0; i < ss.length; i++) {
            //与当前维护的字符串内容对比
            for (int inIndex = leftIndex; inIndex < i; inIndex++) {
                // 假如当前字符与之前的字符串中的字符重复了,把leftIndex置为原串坐标+1,
                // 并判断是否更新最长值,然后break进入下一循环
                if (ss[inIndex] == ss[i]) {
                    maxCount = Math.max(maxCount, i - leftIndex);
                    leftIndex = inIndex + 1;
                    break;
                }
            }
        }
        return Math.max(maxCount, ss.length - leftIndex);
    }

    public static void main(String[] args) {
        String s = "abba";
        lengthOfLongestSubstring(s);
        LengthOfLongestSubstring substring = new LengthOfLongestSubstring();
        substring.lengthOfLongestSubstring3(s);
    }

}
