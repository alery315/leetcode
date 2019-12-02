package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @auther alery
 * @create 2019-12-02 20:28
 */
public class PreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                list.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
//            list.add(node.val);
            node = node.right;

        }

        return list;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(44);
        TreeNode root6 = new TreeNode(3);
        root.left = root1;
        root.right = root2;

        root1.left = root3;
        root1.right = root4;

        root2.left = root5;
        root2.right = root6;


        List<Integer> list = new PreorderTraversal().preorderTraversal(root);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

}
