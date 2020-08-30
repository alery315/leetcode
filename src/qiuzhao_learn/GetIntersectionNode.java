package qiuzhao_learn;

import linkedList.ListNodeHolder;
import linkedList.ListNode;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/8/13 14:51
 * @Version 1.0
 */

public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        int diff = 0;
        ListNode pA = headA, pB = headB;
        while (pA!=null){
            lenA++;
            pA = pA.next;
        }
        while (pB!=null){
            lenB++;
            pB = pB.next;
        }
        if (lenA > lenB) {
            diff = lenA - lenB;
            for (int i = 0; i < diff; i++) {
                headA = headA.next;
            }
        } else {
            diff = lenB - lenA;
            for (int i = 0; i < diff; i++) {
                headB = headB.next;
            }
        }

        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    public static void main(String[] args) {

        new GetIntersectionNode().getIntersectionNode(ListNodeHolder.getInstance(), ListNodeHolder.getInstance());
    }

}
