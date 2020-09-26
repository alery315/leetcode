package qiuzhao_learn;

import linkedList.ListNode;
import linkedList.ListNodeHolder;
import sun.util.resources.iw.LocaleNames_iw;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/4 14:48
 * @Version 1.0
 */

public class HasCycle {

    public boolean hasCycle(ListNode head) {
        ListNode quick = head;
        ListNode low = head;

        if (head.next==null) return false;
        quick = quick.next;
        while (low != null) {
            if (quick == low) {
                return true;
            }
            low = low.next;
            for (int i = 0; i < 2; i++) {
                if (quick != null) {
                    quick = quick.next;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        new HasCycle().hasCycle(ListNodeHolder.getInstance());

    }

}
