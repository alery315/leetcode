package Design;

import java.util.Stack;

public class MinStack {
    /**
     * initialize your data structure here.
     */

    public Stack<Integer> stack;
    public int min_num = Integer.MAX_VALUE;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (x < min_num) min_num = x;
        stack.push(x);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min_num;
    }

    public static void main(String[] args) {

        MinStack obj = new MinStack();
        obj.push(2);
        obj.push(3);
        obj.push(4);
        obj.pop();
        int param_3 = obj.top();
        System.out.println(param_3);
        int param_4 = obj.getMin();
        System.out.println(param_4);
    }

}
