package qiuzhao_learn;

import tree.TreeNode;
import tree.TreeNodeHolder;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/21 19:08
 * @Version 1.0
 */

public class Yuanfudao1 {

    public static void deleteLeafNode(TreeNode node, TreeNode parent, int flag,int target) {
        if (node == null) return;
        if (node.right == null && node.left == null) {
            if (node.val == target && parent != null) {
                if (flag == 1) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
            return;
        }
        deleteLeafNode(node.left, node, 1,target);
        deleteLeafNode(node.right, node, -1,target);
        if (node.val == target && parent != null) {
            if (node.left == null && node.right == null) {
                if (flag == 1) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
        }
    }



    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeHolder.getInstance2();
        deleteLeafNode(treeNode, null, 0,0);
        System.out.println();

    }


}
