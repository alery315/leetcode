package bishi;

import java.util.*;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/12 10:40
 * @Version 1.0
 */

public class Xiaohongshu2 {

    /*请完成下面这个函数，实现题目要求的功能
       当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
******************************开始写代码******************************/
    static int solution(String s) {
        if (s == null || s.length() < 1) return 0;
        int[] dp = new int[s.length()];
        dp[0] = 1;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                dp[i] = Math.min(dp[i - 1] + 1, dp[map.get(c)]);
            } else {
                map.put(c, i);
                dp[i] = dp[i - 1] + 1;
            }
        }
//        int p = 0;
//        int res = 0;
//        while (p < s.length() - 1) {
//            List<Integer> list = map.get(s.charAt(p));
//            int temp = list.get(list.size() - 1);
//            if (temp == p) {
//                p = p + 1;
//            } else {
//                p = temp + 1;
//            }
//            if (p == s.length() - 1) {
//                res++;
//            }
//            res++;
//        }
        return dp[s.length() - 1];
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        String _s;
        try {
            _s = in.nextLine();
        } catch (Exception e) {
            _s = null;
        }

        res = solution(_s);
        System.out.println(String.valueOf(res));

    }

}
