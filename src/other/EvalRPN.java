package other;

import java.awt.*;
import java.sql.SQLOutput;
import java.util.Stack;

/**
 * @auther alery
 * @create 2019-12-13 15:02
 */
public class EvalRPN {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (judge(tokens[i])) {
                stack.add(Integer.valueOf(tokens[i]));
            } else {
                int a = stack.pop();
                int b = stack.pop();
                String opt = tokens[i];
                switch (opt) {
                    case "+":
                        stack.add(b + a);
                        break;
                    case "-":
                        stack.add(b - a);
                        break;
                    case "*":
                        stack.add(b * a);
                        break;
                    case "/":
                        stack.add(b / a);
                        break;
                    default:
                        break;
                }
            }
        }


        return stack.pop();
    }

    public boolean judge(String s) {
        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {

        String[] tokens = {"2", "1", "+", "3", "*"};

        System.out.println(new EvalRPN().evalRPN(tokens));


    }


}
