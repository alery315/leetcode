package qiuzhao_learn;

import java.util.Stack;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/8 14:22
 * @Version 1.0
 */

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        // write code here
        int res = 0;
        int j = 0;
        int maxLen = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else {
                char t = ')';
                if (!stack.isEmpty()) {
                    t = stack.peek();
                }
                if (t == '(') {
                    maxLen = Math.max(maxLen, i - j);
                    stack.pop();
                } else {
                    j = i;
                    stack.push(c);
                }
            }
        }

        return res * 2;
    }


    public int longestValidParentheses2(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        int max_len = 0;
        int last = -1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    last = i;
                } else {
                    stack.pop();
                    // ()((())
                    if (stack.isEmpty()) {
                        max_len = Math.max(max_len, i - last);
                    } else {
                        max_len = Math.max(max_len, i - stack.peek());
                    }
                }
            }
        }
        return max_len;
    }



    public static void main(String[] args) {
        String s = "()((())";
        new LongestValidParentheses().longestValidParentheses2(s);
    }

}
