package offer;

import java.util.LinkedList;
import java.util.Queue;

class CStack {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    /** Initialize your data structure here. */
    public CStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue1.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (empty()) return -1;
        int len = queue1.size();
        for (int i = 0; i < len - 1; i++) {
            queue2.add(queue1.poll());
        }
        int res = queue1.poll();
        for (int i = 0; i < len - 1; i++) {
            queue1.add(queue2.poll());
        }
        return res;
    }
    
    /** Get the top element. */
    public int top() {
        if (empty()) return -1;
        int len = queue1.size();
        for (int i = 0; i < len; i++) {
            queue2.add(queue1.poll());
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (i == len-1) res = queue2.peek();
            queue1.add(queue2.poll());
        }
        return res;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }


    public static void main(String[] args) {
        CStack cStack = new CStack();
        cStack.push(1);
        cStack.push(2);
        cStack.push(3);
        cStack.pop();
        cStack.pop();
        cStack.pop();
        cStack.empty();


    }
}