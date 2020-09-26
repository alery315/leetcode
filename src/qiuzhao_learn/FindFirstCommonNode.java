package qiuzhao_learn;

import linkedList.ListNode;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/3 19:00
 * @Version 1.0
 */

public class FindFirstCommonNode {
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        int len1 = 0, len2 = 0;
        while (p1 != null) {
            len1++;
            p1 = p1.next;
        }
        while (p2 != null) {
            len2++;
            p2 = p2.next;
        }
        if (len1 < len2) {
            int t = len1;
            len1 = len2;
            len2 = t;
            ListNode tNode = pHead1;
            pHead2 = pHead1;
            pHead1 = tNode;
        }
        int diff = len1 - len2;
        for (int i = 0; i < diff; i++) {
            pHead1 = pHead1.next;
        }
        while (pHead1 != null) {
            if (pHead1 == pHead2) {
                return pHead1;
            }
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return null;
    }
}
