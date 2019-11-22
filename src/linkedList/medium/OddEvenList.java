package linkedList.medium;

import linkedList.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @auther alery
 * @create 2019-11-22 15:09
 */
public class OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }

        p = head;

        for (int i = 0; i < list.size(); i++) {
            p.val = list.get(i);
            i++;
            p = p.next;
        }

        for (int i = 1; i < list.size(); i++) {
            p.val = list.get(i);
            i++;
            p = p.next;
        }

//        while (head != null) {
//            System.out.println(head.val);
//            head = head.next;
//        }

        return head;
    }

    // 双指针,把奇偶链表直接分割开
    public ListNode oddEvenList2(ListNode head) {
        if (head == null) return null;
        ListNode p = head;
        ListNode even = new ListNode(-1);
        ListNode even_p = even;
        while (p != null) {

            if (p.next == null) break; // 12345 奇数个的情况,防止后面链接时候p.next为空

            even_p.next = p.next; // 把偶数接到偶数链表
            p.next = p.next.next; // 把俩奇数链接起来
            even_p.next.next = null; // 偶数后面的砍掉

            if (p.next == null) break; // 123456 偶数个的情况,防止后面链接时候p.next为空

            // 俩指针向后移动
            p = p.next;
            even_p = even_p.next;

        }
        p.next = even.next;
        return head;
    }

    public static void main(String[] args) {

        ListNode root = new ListNode(1);
        ListNode root1 = new ListNode(2);
        ListNode root2 = new ListNode(3);
        ListNode root3 = new ListNode(4);
        ListNode root4 = new ListNode(5);
        ListNode root5 = new ListNode(6);
        ListNode root6 = new ListNode(7);

        root.next = root1;
        root1.next = root2;
        root2.next = root3;
        root3.next = root4;
        root4.next = root5;
        root5.next = root6;

        ListNode p = new OddEvenList().oddEvenList2(root);
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }

    }



}
