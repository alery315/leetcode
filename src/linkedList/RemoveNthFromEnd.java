package linkedList;

import com.sun.nio.sctp.SctpChannel;
import com.sun.nio.sctp.SendFailedNotification;

public class RemoveNthFromEnd {

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode firstp = dummy, secondp = dummy;

        for (int i = 0; i <= n; i++) {
            firstp = firstp.next;
        }

        while (firstp != null) {
            firstp = firstp.next;
            secondp = secondp.next;
        }

        secondp.next = secondp.next.next;

        return dummy.next;


    }

    public static void main(String[] args) {

        ListNode head = new ListNode(2);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        head = removeNthFromEnd(head, 4);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }




    }


}
