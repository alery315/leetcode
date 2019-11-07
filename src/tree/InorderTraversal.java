package tree;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {

    public List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {

        dfs(root);

        return list;
    }

    public void dfs(TreeNode node) {
        if (node == null) return;
        if (node.left != null) dfs(node.left);
        list.add(node.val);
        if (node.right != null) dfs(node.right);

    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);

        root.right = root1;

        root1.left = root2;

        List<Integer> list = new InorderTraversal().inorderTraversal(root);
        for (Integer integer : list) {
            System.out.println(integer);
        }

    }

}
