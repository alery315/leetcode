package linkedList;

public class IsPalindrome {

    /**
     * 思路,先算出长度,然后反转一半,奇数情况cur指针next一次
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        ListNode p = head;
        ListNode cur = head;
        ListNode pre = null;
        int count = 0;
        while (p != null) {
            p = p.next;
            count++;
        }

        if (count == 1) {
            return true;
        }

        for (int i = 0; i < count / 2; i++) {

            ListNode next = cur.next;

            cur.next = pre;

            pre = cur;

            cur = next;

        }

        if ((count & 1) == 1){
            cur = cur.next;
        }

        while (cur != null) {
            System.out.println(cur.val + " : " + pre.val);
            if (cur.val != pre.val) {
                return false;
            }
            cur = cur.next;
            pre = pre.next;
        }


        return true;
    }


    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        head1.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        System.out.println(isPalindrome(head1));


    }

}
