package offer;

import tree.TreeNode;

/**
 * @author alery
 * @Description
 * @create 2020-06-01 21:56
 */
public class BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int pre_left, int pre_right, int[] inorder, int in_left, int in_right) {
        // 退出条件
        if (pre_left > pre_right || in_left > in_right) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[pre_left]);
        int first = preorder[pre_left];
        int p_first_inorder = -1;
        for (int i = in_left; i < in_right + 1; i++) {
            if (first == inorder[i]) {
                p_first_inorder = i;
                break;
            }
        }

        int len_left = p_first_inorder - in_left;
        if (len_left > 0) {
            treeNode.left = build(preorder, pre_left + 1, pre_left + len_left,
                    inorder, p_first_inorder - len_left, p_first_inorder - 1);
        } else {
            treeNode.left = null;
        }

        int len_right = pre_right - pre_left + 1 - len_left - 1;
        if (len_right > 0) {
            treeNode.right = build(preorder, pre_left + len_left + 1,
                    pre_left + len_left + 1 + len_right - 1,
                    inorder, p_first_inorder + 1, p_first_inorder + 1 + len_right - 1);
        } else {
            treeNode.right = null;
        }

        return treeNode;
    }

    public static void main(String[] args) {

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        BuildTree buildTree = new BuildTree();
        buildTree.buildTree(preorder, inorder);


    }

}
