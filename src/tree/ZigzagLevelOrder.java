package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @auther alery
 * @create 2019-12-01 15:52
 */
public class ZigzagLevelOrder {
    public List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        dfs(root, 0);

        for (int i = 0; i < lists.size(); i++) {
            if ((i & 1) == 1) {
                Collections.reverse(lists.get(i));
            }
        }
        return lists;
    }

    public void dfs(TreeNode root, int depth) {
        if (root == null) return;
        if (depth == lists.size()) {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            lists.add(list);
        } else {
            lists.get(depth).add(root.val);
        }
        if (root.left != null) dfs(root.left, depth + 1);
        if (root.right != null) dfs(root.right, depth + 1);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);
        TreeNode root3 = new TreeNode(4);
        TreeNode root4 = new TreeNode(5);
        TreeNode root5 = new TreeNode(6);
        TreeNode root6 = new TreeNode(7);
        root.left = root1;
        root.right = root2;

        root1.left = root3;
        root1.right = root4;

        root2.left = root5;
        root2.right = root6;


        List<List<Integer>> lists = new ZigzagLevelOrder().zigzagLevelOrder(root);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }


    }
}
