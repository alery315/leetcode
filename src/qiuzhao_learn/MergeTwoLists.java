package qiuzhao_learn;

import linkedList.ListNode;
import linkedList.ListNodeHolder;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/4 15:05
 * @Version 1.0
 */

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write code here
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1 == null && l2 == null) return l1;

        ListNode pre = new ListNode(-1);
        ListNode res = pre;
        pre.next = l1;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null && p2 != null) {
            if (p1.val >= p2.val) {
                ListNode temp = p2.next;
                pre.next = p2;
                p2.next = p1;
                pre = p2;
                p2 = temp;
            } else {
                p1 = p1.next;
            }
        }
        return res.next;
    }

    public static void main(String[] args) {

        new MergeTwoLists().mergeTwoLists(ListNodeHolder.getInstance(), ListNodeHolder.getInstance2());

    }
}
