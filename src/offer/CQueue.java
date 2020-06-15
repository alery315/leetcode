package offer;

import java.util.Stack;

class CQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void appendTail(int value) {
        stack1.add(value);
    }
    
    public int deleteHead() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            if (!stack1.isEmpty()) {
                int len = stack1.size();
                for (int i = 0; i < len; i++) {
                    stack2.add(stack1.pop());
                }
                return stack2.pop();
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) {

        CQueue cQueue = new CQueue();

        cQueue.appendTail(1);
        cQueue.appendTail(2);
        cQueue.appendTail(3);
        cQueue.deleteHead();
        cQueue.appendTail(4);
        cQueue.appendTail(5);
        cQueue.deleteHead();
        cQueue.deleteHead();
        cQueue.deleteHead();
        cQueue.deleteHead();



    }

}