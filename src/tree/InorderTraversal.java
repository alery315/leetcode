package tree;

import linkedList.ListNode;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    /**
     * 对已经遍历过的做上标记,下次遇到直接输出,每个结点会入栈两次
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Stack<ColorNode> stack = new Stack<>();
        stack.push(new ColorNode(root, "no"));
        while (!stack.isEmpty()) {
            ColorNode colorNode = stack.pop();

            if (colorNode.color.equals("no")) {
                if (colorNode.node.right != null) stack.push(new ColorNode(colorNode.node.right, "no"));
                stack.push(new ColorNode(colorNode.node, "yes"));
                if (colorNode.node.left != null) stack.push(new ColorNode(colorNode.node.left, "no"));
            } else {
                list.add(colorNode.node.val);
            }
        }
        return list;
    }

    /**
     * 正常的迭代方法
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            list.add(node.val);
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




        List<Integer> list = new InorderTraversal().inorderTraversal3(root);
        for (Integer integer : list) {
            System.out.println(integer);
        }

    }

}

class ColorNode {
    TreeNode node;
    String color;

    public ColorNode(TreeNode node,String color){
        this.node = node;
        this.color = color;
    }
}
