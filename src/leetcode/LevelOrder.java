package leetcode;

import tree.TreeNode;

import java.util.*;

/**
 * @author 丶Alery
 * @Description
 * @create 2020-03-23 17:16
 */
public class LevelOrder {
    public static int[] levelOrder(TreeNode root) {
        if (root == null) return new int[]{0};
        int pos = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            res.add(t.val);
            if (t.left!=null) queue.add(t.left);
            if (t.right!=null) queue.add(t.right);
        }
        int[] res_array = new int[res.size()];
        for (int i = 0; i < res_array.length; i++) {
            res_array[i] = res.get(i);
        }
        return res_array;
    }

    public static void main(String[] args) {



    }
}
