package linkedList.simple;

import linkedList.ListNode;

public class ReverseList {

    public static ListNode reverseList(ListNode head) {


        ListNode cur = head, pre = null;

        while (cur != null) {

            ListNode next = cur.next;

            cur.next = pre;

            pre = cur;

            cur = next;

        }

        return pre;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(5);
        ListNode node1 = new ListNode(6);
        ListNode node2 = new ListNode(7);
        ListNode node3 = new ListNode(8);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        head = reverseList(head);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }


    }

}
