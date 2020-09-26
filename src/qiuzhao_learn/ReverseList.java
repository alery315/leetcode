package qiuzhao_learn;

import com.sun.org.apache.regexp.internal.RE;
import linkedList.ListNode;
import linkedList.ListNodeHolder;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/3 18:24
 * @Version 1.0
 */

public class ReverseList {

    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode p = head;
        if (head==null) return head;
        ListNode nex = head.next;

        while (nex != null) {
            ListNode t = nex.next;
            p.next = pre;
            nex.next = p;
            pre = p;
            p = nex;
            nex = t;
        }

        return p;
    }

    public static void main(String[] args) {
        new ReverseList().reverseList(ListNodeHolder.getInstance());
    }

}
