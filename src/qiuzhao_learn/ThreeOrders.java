package qiuzhao_learn;

import tree.TreeNode;
import tree.TreeNodeHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/3 18:44
 * @Version 1.0
 */

public class ThreeOrders {

    public int[][] threeOrders(TreeNode root) {

        if (root == null) return null;
        List<Integer> list = new ArrayList<>();
        DLR(root, list);
        int len = list.size();
        int[][] res = new int[3][len];
        for (int i = 0; i < list.size(); i++) {
            res[0][i] = list.get(i);
        }
        list.clear();
        LDR(root, list);
        for (int i = 0; i < list.size(); i++) {
            res[1][i] = list.get(i);
        }
        list.clear();
        LRD(root, list);
        for (int i = 0; i < list.size(); i++) {
            res[2][i] = list.get(i);
        }
        return res;
    }

    public void DLR(TreeNode root, List<Integer> list) {
        if (root != null) list.add(root.val);
        if (root.left != null) DLR(root.left, list);
        if (root.right != null) DLR(root.right, list);
    }

    public void LDR(TreeNode root, List<Integer> list) {
        if (root.left != null) LDR(root.left, list);
        if (root != null) list.add(root.val);
        if (root.right != null) LDR(root.right, list);
    }

    public void LRD(TreeNode root, List<Integer> list) {
        if (root.left != null) LRD(root.left, list);
        if (root.right != null) LRD(root.right, list);
        if (root != null) list.add(root.val);
    }

    public static void main(String[] args) {
        new ThreeOrders().threeOrders(TreeNodeHolder.getInstance());
    }


}
