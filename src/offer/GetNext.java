package offer;

import javax.transaction.TransactionRequiredException;

/**
 * @author alery
 * @Description
 * @create 2020-06-15 16:25
 */
public class GetNext {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return null;
        TreeLinkNode treeLinkNode = null;

        if (pNode.right != null) {
            while (pNode != null) {
                pNode = pNode.left;
            }
            treeLinkNode = pNode;
        } else if (pNode.next != null) {
            if (pNode.next.left == pNode) {
                treeLinkNode = pNode.next;
            } else {
                TreeLinkNode pCurrent = pNode;
                TreeLinkNode pParent = pNode.next;
                while (pCurrent != null && pParent.right == pCurrent) {
                    pCurrent = pParent;
                    pParent = pParent.next;
                }
                treeLinkNode = pParent;
            }
        }


        return treeLinkNode;
    }

}
