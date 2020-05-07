package niuke;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 丶Alery
 * @Description
 * @create 2020-03-13 22:42
 */
public class PrintListFromTailToHead {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null) return list;
        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }
        Collections.reverse(list);
        return list;
    }

}
