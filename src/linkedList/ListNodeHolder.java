package linkedList;

/**
 * @author alery
 * @Description
 * @create 2020-07-29 20:38
 */
public class ListNodeHolder {
    public static ListNode head;

    public static ListNode getInstance() {
        ListNode root = new ListNode(1);
        ListNode root1 = new ListNode(2);
        ListNode root2 = new ListNode(3);
        ListNode root3 = new ListNode(4);
        ListNode root4 = new ListNode(5);

        root.next = root1;
        root1.next = root2;
        root2.next = root3;
        root3.next = root4;
        root4.next = null;
        head = root;
        return head;
    }
}
