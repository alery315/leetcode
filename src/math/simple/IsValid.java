package math.simple;

import java.util.Stack;

public class IsValid {

    /**
     * 这个思路比较清晰,明确
     * 不是括号的前一个[{(,先判断栈是否为空,然后判断出栈的是否对应,最后判断栈是否为空
     * @param s
     * @return
     */
    public static boolean isValid2(String s) {
        if(s == null) return false;
        if(s.length() == 0) return true;

        Stack<Character> stack = new Stack<>();

        for(int i=0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{'){
                //进栈
                stack.push(ch);
            }else{
                if(stack.isEmpty()) return false;
                if(ch == ')'){
                    if(stack.pop() != '(') return false;
                }else if(ch == ']'){
                    if(stack.pop() != '[') return false;
                }else{
                    if(stack.pop() != '{') return false;
                }
            }
        }
        return stack.isEmpty();
    }



    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        int len = s.length();
        if ((len & 1) == 1) {
            return false;
        }
        int flag = 0;
        for (int i = 0; i < len; i++) {
            Character c = s.charAt(i);
            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
                continue;
            }
            if (c == ')') {
                if (stack.isEmpty()) {
                    flag = 1;break;
                } else if (stack.pop() != '(') {
                    flag = 1;break;
                }
                continue;
            }
            if (c == ']') {
                if (stack.isEmpty()) {
                    flag = 1;break;
                } else if (stack.pop() != '[') {
                    flag = 1;break;
                }
                continue;
            }
            if (c == '}') {
                if (stack.isEmpty()) {
                    flag = 1;break;
                } else if (stack.pop() != '{') {
                    flag = 1;break;
                }
                continue;
            }
        }
        return flag == 0 && stack.isEmpty();
    }


    public static void main(String[] args) {

        System.out.println(isValid("()(())"));
        System.out.println(isValid2("(("));

    }
}
