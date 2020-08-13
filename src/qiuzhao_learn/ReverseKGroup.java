package qiuzhao_learn;

import linkedList.Holder;
import linkedList.ListNode;

import java.io.PrintStream;

/**
 * @author alery
 * @Description
 * @create 2020-07-29 20:36
 */
public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k < 2) return head;
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
        int cycle = len / k;
        int left = len % k;
        System.out.println(cycle);
        p = head;
        ListNode next = p.next;
        ListNode pre = null;
        ListNode t = null;
        ListNode res = new ListNode(-1);
        ListNode res_p = res;
        for (int i = 0; i < cycle; i++) {
            for (int j = 0; j < k - 1; j++) {
                p.next = pre;
                t = next.next;
                next.next = p;
                pre = p;
                p = next;
                next = t;
            }
            while (res_p.next != null) res_p = res_p.next;
            res_p.next = p;
            p = next;
            if (next != null) next = next.next;
            pre = null;
        }
        if (left != 0) {
            while (res_p.next != null) res_p = res_p.next;
            res_p.next = p;
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode head = Holder.getInstance();
        ListNode head2 = new ReverseKGroup().reverseKGroup(head, 5);
        System.out.println(head2.val);
    }

}
