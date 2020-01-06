package test;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @auther alery
 * @create 2020-01-03 15:09
 */
public class GetAllElements {

    public List<Integer> res = new ArrayList<>();

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        dfs(root1);
        dfs(root2);
        Collections.sort(res);
        for (Integer re : res) {
            System.out.println(re);
        }
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        if (root != null) res.add(root.val);
        if (root.left != null) dfs(root.left);
        if (root.right != null) dfs(root.right);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(6);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(6);
        TreeNode root5 = new TreeNode(4);
        root.left = root1;
        root.right = root2;

        root2.left = root3;
        root2.right = root4;

//        root4.right = root5;

        new GetAllElements().getAllElements(root, null);
        System.out.println();




    }

}
