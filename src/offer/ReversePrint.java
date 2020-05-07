package offer;

import linkedList.ListNode;

import java.util.Stack;

/**
 * @author alery
 * @Description
 * @create 2020-05-07 22:42
 */
public class ReversePrint {

    public static int[] reversePrint(ListNode head) {
        int[] res;
        Stack<Integer> stack = new Stack<>();
        if (head == null) {
            return null;
        }
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {

    }

}
