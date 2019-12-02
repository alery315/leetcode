package tree;

import com.sun.source.tree.Tree;

import java.util.Arrays;
import java.util.Collections;

/**
 * @auther alery
 * @create 2019-12-02 21:41
 */
public class BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || preorder == null) return null;
        return dfs(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode dfs(int[] preorder, int s1, int e1, int[] inorder, int s2, int e2) {
        if (s1 > e1 || s2 > e2) return null;
        TreeNode node = new TreeNode(preorder[s1]);
        int split = 0;
        for (int i = s2; i <= e2; i++) {
            if (inorder[i] == preorder[s1]) {
                split = i;
                break;
            }
        }
        int left_len = split - s2;
//        int right_len = e2 - split;
        if (s1 == e1 && s2 == e2) return node;
        node.left = dfs(preorder, s1 + 1, s1 + left_len, inorder, s2, split - 1);
        node.right = dfs(preorder, s1 + left_len + 1, e1, inorder, split + 1, e2);

        return node;
    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        TreeNode root1 = new TreeNode(9);
        TreeNode root2 = new TreeNode(20);
        TreeNode root3 = new TreeNode(15);
        TreeNode root4 = new TreeNode(7);

        root.left = root1;

        root.right = root2;

        root2.left = root3;
        root2.right = root4;

//        int[] nums1 = {3, 9, 20, 15, 7};
        int[] nums1 = {1,2};
//        int[] nums2 = {7, 3, 15, 20, 7};
        int[] nums2 = {2,1};

        TreeNode node = new BuildTree().buildTree(nums1, nums2);

        System.out.println("ok");


    }



}
