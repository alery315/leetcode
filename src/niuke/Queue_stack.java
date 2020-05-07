package niuke;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author 丶Alery
 * @Description
 * @create 2020-03-27 15:59
 */
public class Queue_stack {

    private Queue<Integer> queue1 = new ArrayDeque<>();
    private Queue<Integer> queue2 = new ArrayDeque<>();

    public void push(Integer integer) {
        queue1.add(integer);
    }

    public Integer pop() {
        int len = queue1.size() - 1;
        for (int i = 0; i < len; i++) {
            queue2.add(queue1.poll());
        }
        Integer res = queue1.poll();
        while (!queue2.isEmpty()) {
            queue1.add(queue2.poll());
        }
        return res;
    }


    public static void main(String[] args) {
        Queue_stack sim_stack = new Queue_stack();

        for (int i = 0; i < 10; i++) {
            sim_stack.push(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(sim_stack.pop());
        }
    }
}
