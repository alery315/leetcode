package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LevelOrder {

    public int depth = 0;
    public List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {

        dfs(root, depth);

        return lists;
    }

    public void dfs(TreeNode root, int depth) {
        if (depth > this.depth) this.depth = depth;
        if (root == null) return;
        if (depth == lists.size()) {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            lists.add(list);
        }else {
            lists.get(depth).add(root.val);
        }
        if (root.left != null) dfs(root.left, depth + 1);
        if (root.right != null) dfs(root.right, depth + 1);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        TreeNode root1 = new TreeNode(9);
        TreeNode root2 = new TreeNode(20);
        TreeNode root3 = new TreeNode(30);
        TreeNode root4 = new TreeNode(23);
        TreeNode root5 = new TreeNode(21421);
        root.left = root1;
        root.right = root2;

        root2.left = root3;
        root2.right = root4;

        root4.right = root5;

        List<List<Integer>> lists = new LevelOrder().levelOrder(root);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

}
