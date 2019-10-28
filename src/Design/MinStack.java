package Design;

import java.util.Stack;

public class MinStack {
    /**
     * initialize your data structure here.
     */

    public Stack<Integer> stack;
    public Stack<Integer> min_stack;
    public int min_num = Integer.MAX_VALUE;

    public MinStack() {
        stack = new Stack<>();
        min_stack = new Stack<>();
    }

    public void push(int x) {
        if (min_stack.size() == 0 || x <= min_stack.peek()) min_stack.push(x);
        stack.push(x);
    }

    public void pop() {
        if (min_stack.size() != 0 && stack.peek().equals( min_stack.peek())) {
            min_stack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min_stack.peek();
    }

    public static void main(String[] args) {

        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        obj.pop();
        int param_3 = obj.top();
        System.out.println(param_3);
        int param_4 = obj.getMin();
        System.out.println(param_4);
    }

}
