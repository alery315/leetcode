package linkedList.simple;

import linkedList.ListNode;

public class DeleteNode {

    public void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;

    }


    public static void main(String[] args) {




    }

}


