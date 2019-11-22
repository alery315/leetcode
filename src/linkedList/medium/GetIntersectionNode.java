package linkedList.medium;

import linkedList.ListNode;

/**
 * 思路:让两个链表尾端对齐,并让长链表的遍历指针对齐短链表的指针
 * 比如 1 2 3 4 5 与 8 4 5
 * 让第一个链表遍历指针到3,与第二个链表对齐
 * 先算出俩链表的长度,计算差值,比较哪个大,让大的遍历指针先跑差值个长度
 *
 * @auther alery
 * @create 2019-11-22 16:31
 */
public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA, pB = headB;
        int lenA = 0;
        int lenB = 0;
        // calc length
        while (pA != null) {
            lenA++;
            pA = pA.next;
        }
        while (pB != null) {
            lenB++;
            pB = pB.next;
        }

        // calc difference and move big pointer
        int diff;
        pA = headA;
        pB = headB;
        if (lenA > lenB) {
            diff = lenA - lenB;
            for (int i = 0; i < diff; i++) {
                pA = pA.next;
            }
        } else {
            diff = lenB - lenA;
            for (int i = 0; i < diff; i++) {
                pB = pB.next;
            }
        }


        ListNode ans = null;

        // compare after aligning
        while (pA != null) {
            if (pA == pB) {
                ans = pA;
                break;
            }
            pA = pA.next;
            pB = pB.next;
        }

        return ans;
    }

    public static void main(String[] args) {

        ListNode root = new ListNode(0);
        ListNode root1 = new ListNode(1);
        ListNode root2 = new ListNode(9);
        ListNode root3 = new ListNode(2);
        ListNode root4 = new ListNode(4);


        root.next = root1;
        root1.next = root2;
        root2.next = root3;
        root3.next = root4;

        ListNode head = new ListNode(3);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(4);

        head.next = root3;
//        head1.next = head2;

        ListNode p = new GetIntersectionNode().getIntersectionNode(head, root);

        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }



    }

}
