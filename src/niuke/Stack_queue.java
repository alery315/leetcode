package niuke;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author 丶Alery
 * @Description
 * @create 2020-03-27 16:15
 6
 add 1
 add 2
 add 3
 peek
 poll
 peek
 */
public class Stack_queue {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void add(Integer integer) {
        stack1.add(integer);
    }

    public Integer poll() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public Integer peak() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public static void main(String[] args) {
        Stack_queue stack_queue = new Stack_queue();
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        String s;
        String op;
        int val;
        for (int i = 0; i < n; i++) {
            s = sc.nextLine();
            op = s.split(" ")[0];
            switch (op) {
                case "add":
                    val = Integer.valueOf(s.split(" ")[1]);
                    stack_queue.add(val);
                    break;
                case "peek":
                    System.out.println(stack_queue.peak());
                    break;
                default:
                    stack_queue.poll();
                    break;
            }
        }
    }
}
