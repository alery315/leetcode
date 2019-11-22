package linkedList.simple;

import linkedList.ListNode;

import java.util.HashSet;
import java.util.Set;

public class HasCycle {

    // hash方法
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) return true;
            set.add(head);
            head = head.next;
        }

        return false;
    }

    // 双快慢指针法
    public boolean hasCycle2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next != null ? fast.next.next : null;
            if (fast == slow && fast != null) return true;
        }
        return false;
    }

    public static void main(String[] args) {

        ListNode head1 = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        head1.next = node1;
        node1.next = head1;
        node2.next = node3;
        node3.next = node1;

        System.out.println(new HasCycle().hasCycle2(head1));
    }
}
