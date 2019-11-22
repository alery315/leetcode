package linkedList.medium;

import linkedList.ListNode;

/**
 * @auther alery
 * @create 2019-11-22 14:22
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int rest = 0;
        ListNode ans = new ListNode(-1);
        ListNode p = ans;
        while (l1 != null || l2 != null) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);
            ListNode listNode = new ListNode((sum+rest) % 10); // 计算当前位+进位后的值对10取余
            rest = (sum + rest) / 10; // 计算进位
            p.next = listNode; // 向后位移
            p = listNode;
            l1 = l1 != null ? l1.next : null; // 看情况位移
            l2 = l2 != null ? l2.next : null;
        }
        if (rest != 0) { // 最后还有进位
            p.next = new ListNode(rest);
        }
        return ans.next;
    }

    public static void main(String[] args) {

        ListNode root1 = new ListNode(2);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(9);
        root1.next = node1;
        node1.next = node2;
        node2.next = node3;

        ListNode root2 = new ListNode(5);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(4);
        root2.next = node4;
        node4.next = node5;

        System.out.println(new AddTwoNumbers().addTwoNumbers(root1, root2));

    }


}
