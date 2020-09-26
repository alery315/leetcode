package qiuzhao_learn;

import tree.TreeNode;
import tree.TreeNodeHolder;

import java.util.BitSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/21 20:51
 * @Version 1.0
 */

public class Codec {
    public static String serialize(TreeNode root) {
        if (root == null) return "[]";
        StringBuilder res = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                res.append(node.val + ",");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                res.append("null,");
            }

        }
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    public static TreeNode deserialize(String data) {
        if (data.equals("[]")) return null;
        String[] vals = data.substring(1, data.length() - 1).split(",");
        System.out.println(vals);
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!vals[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            i++;
            if (!vals[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }
            i++;
        }
        
        return root;
    }

    public static void main(String[] args) {
        String s = serialize(TreeNodeHolder.getInstance());
        System.out.println(s);
        TreeNode node = deserialize(s);
        System.out.println();
    }

}
