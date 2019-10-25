package linkedList;

public class MergeTwoLists {


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode node = new ListNode(0);
        node.next = null;

        ListNode p = node;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                p.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null) {
            p.next = l1;
        } else {
            p.next = l2;
        }

        return node.next;
    }

    public static void main(String[] args) {


        ListNode head1 = new ListNode(1);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        head1.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        ListNode head2 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        head2.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;


        ListNode head = mergeTwoLists(head1, head2);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }


    }

}
